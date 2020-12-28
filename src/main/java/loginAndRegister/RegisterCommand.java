package loginAndRegister;

import account.Account;
import account.AdminAccount;
import account.CustomerAccount;
import account.FacadeAccount;
import webUsers.WebUsers;

import java.util.List;
import java.util.Scanner;

public class RegisterCommand implements Command {

    @Override
    public void execute() {
        createAccount(WebUsers.getInstance().getAccountList());
    }

    @SuppressWarnings("ConstantConditions")
    private static void createAccount(List<FacadeAccount> listOfAccounts) {
        String name;
        String surname;
        String login;
        String password;
        String email;
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj imie");
        name = scanner.next();
        System.out.println("podaj nazwisko");
        surname = scanner.next();

        System.out.println("podaj login");
        login = scanner.next();
        System.out.println("podaj haslo");
        password = scanner.next();

        if (login.startsWith("[ADMIN]")) {
            if (addAdminAccount(listOfAccounts, name, surname, login, password)) {
                logIn(listOfAccounts, login, password).accountLoop();
            } else {
                System.out.println("niewłaściwy login lub hasło");
                Register.logOrRegister();
            }
        } else {
            System.out.println("podaj email");
            email = scanner.next();
            if (addCustomerAccount(listOfAccounts, name, surname, login, password, email)) {
                logIn(listOfAccounts, login, password).accountLoop();
            } else {
                System.out.println("niewłaściwy login lub hasło");
                Register.logOrRegister();
            }
        }
    }

    private static boolean addAdminAccount(List<FacadeAccount> listOfAccounts, String name, String surname, String login, String password) {
        if (checkLoginAndPassword(listOfAccounts, login, password)) {
            Account newAdmin = new AdminAccount(name, surname, login, password, listOfAccounts.size());
            listOfAccounts.add(newAdmin);
            System.out.println("rejestracja admina przebiegla pomyslnie");
            return true;
        } else {
            System.out.println("nie mozna zarejestrowac admina");
            return false;
        }
    }

    private static boolean addCustomerAccount(List<FacadeAccount> listOfAccounts, String name, String surname, String login, String password, String email) {
        if (checkLoginAndPassword(listOfAccounts, login, password)) {
            Account newCustomer = new CustomerAccount(name, surname, login, password, listOfAccounts.size(), email);
            listOfAccounts.add(newCustomer);
            System.out.println("rejestracja nowego użytkownika przebiegla pomyslnie");
            return true;
        } else {
            System.out.println("nie mozna zarejestrowac użytkownika");
            return false;
        }
    }

    private static boolean checkLoginAndPassword(List<FacadeAccount> listOfAccounts, String login, String password) {
        for (FacadeAccount account : listOfAccounts) {
            if (account.getLogin().equals(login)) {
                return false;
            }
        }
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    private static FacadeAccount logIn(List<FacadeAccount> listOfAccounts, String login, String password) {
        for (FacadeAccount account : listOfAccounts) {
            if (account.getLogin().equals(login) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
}
