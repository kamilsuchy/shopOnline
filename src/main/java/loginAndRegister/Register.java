package loginAndRegister;

import account.Account;
import account.AdminAccount;
import account.CustomerAccount;

import java.util.ArrayList;
import java.util.List;

public class Register {

    List<Account> listOfAccount;

    public Register() {
        listOfAccount = new ArrayList<>();
    }

    private boolean checkLoginAndPassword(String login, String password) {
        for (Account account : listOfAccount) {
            if (account.getLogin().equals(login)) {
                return false;
            }
        }
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    public boolean addCustomerAccount(String name, String surname, String login, String password, String email) {
        if (checkLoginAndPassword(login, password)) {
            Account newCustomer = new CustomerAccount(name, surname, login, password, listOfAccount.size(), email);
            listOfAccount.add(newCustomer);
            System.out.println("rejestracja nowego użytkownika przebiegla pomyslnie");
            return true;
        } else {
            System.out.println("nie mozna zarejestrowac użytkownika");
            return false;
        }
    }

    public boolean logIn(String login, String password) {
        for (Account account : listOfAccount) {
            if (account.getLogin().equals(login) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean addAdminAccount(String name, String surname, String login, String password) {
        if (checkLoginAndPassword(login, password)) {
            Account newAdmin = new AdminAccount(name, surname, login, password, listOfAccount.size());
            listOfAccount.add(newAdmin);
            System.out.println("rejestracja admina przebiegla pomyslnie");
            return true;
        } else {
            System.out.println("nie mozna zarejestrowac admina");
            return false;
        }
    }
}