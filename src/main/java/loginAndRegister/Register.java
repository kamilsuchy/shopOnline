package loginAndRegister;

import webUsers.WebUsers;
import account.Account;
import account.AdminAccount;
import account.CustomerAccount;
import account.UserState;

import java.util.List;
import java.util.Scanner;

public class Register {


    private static boolean checkLoginAndPassword(List<Account> listOfAccounts, String login, String password) {
        for (Account account : listOfAccounts) {
            if (account.getLogin().equals(login)) {
                return false;
            }
        }
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    public static boolean addCustomerAccount(List<Account> listOfAccounts, String name, String surname, String login, String password, String email) {
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

    public static Account logIn(List<Account> listOfAccounts, String login, String password) {
        for (Account account : listOfAccounts) {
            if (account.getLogin().equals(login) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    public static boolean addAdminAccount(List<Account> listOfAccounts, String name, String surname, String login, String password) {
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

    public static boolean isBanned(CustomerAccount account){
        return account.getClass() == CustomerAccount.class &&
                (account.getUserState() == UserState.BLOCKED ||
                        account.getUserState() == UserState.BANNED);
    }

    public static void logInAccount(List<Account> listOfAccounts) {
        Scanner scanner = new Scanner(System.in);
//        while (true) {
            System.out.println("podaj login");
            String login = scanner.next();
            System.out.println("podaj haslo");
            String password = scanner.next();
            Account account;
            if ( (account = logIn(listOfAccounts, login, password))!= null ) {
                if ( isBanned((CustomerAccount) account)){
                    System.out.println("Nie mozna zalogowac. Uzytkownik zbanowany lub zablokowany");
                    logOrRegister();
                }else{
                    System.out.println("zalogowano poprawnie");
                    account.accountLoop();
//                break;
                }
            }else{
                System.out.println("niepoprawny login lub haslo");
                logOrRegister();
            }
//        }
    }
    @SuppressWarnings("ConstantConditions")
    public static void createAccount(List<Account> listOfAccounts) {
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
       // while (true) {
            System.out.println("podaj login");
            login = scanner.next();
            System.out.println("podaj haslo");
            password = scanner.next();

            if (login.startsWith("[ADMIN]")){
                if (addAdminAccount(listOfAccounts, name, surname, login, password)) {
                    logIn(listOfAccounts, login, password).accountLoop();
                    //      break;
                }else {
                    System.out.println("niewłasciwy login lub hasło");
                    logOrRegister();
                }
            }else{
                System.out.println("podaj email");
                email = scanner.next();
                if (addCustomerAccount(listOfAccounts, name, surname, login, password, email)) {
                    logIn(listOfAccounts, login, password).accountLoop();
                    //      break;
                } else {
                    System.out.println("niewłasciwy login lub hasło");
                    logOrRegister();
                }
            }

        //}
    }

    public static void logOrRegister(){
        System.out.println("1 - logowanie");
        System.out.println("2 - rejestracja");
        System.out.println("3 - zakoncz");
        Scanner scanner = new Scanner(System.in);
        int c;
        while ((c = scanner.nextInt()) != 1 && c != 2 && c!=3) {
            scanner.nextInt();
        }
        if (c == 1) {
            logInAccount(WebUsers.getInstance().getAccountList());
        } else if (c == 2){
            createAccount(WebUsers.getInstance().getAccountList());
        }
    }
}