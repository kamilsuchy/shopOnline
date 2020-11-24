import loginAndRegister.Register;

import java.util.Scanner;

public class ShopOnline {
    private static ShopOnline instance;
    private static Register register;

    private ShopOnline() {
        register = new Register();
    }

    public static ShopOnline getInstance() {
        if (instance == null) {
            instance = new ShopOnline();
        }
        return instance;
    }

    private static void createAccount() {
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
        while (true) {
            System.out.println("podaj login");
            login = scanner.next();
            System.out.println("podaj haslo");
            password = scanner.next();
            System.out.println("podaj email");
            email = scanner.next();
            if (register.addCustomerAccount(name, surname, login, password, email)) {
                //todo przeniesc uzytkownika do interface uzytkownika
                break;
            } else {
                System.out.println("niewłasciwy login lub hasło");
            }
        }
    }

    private static void logInAccount() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("podaj login");
            String login = scanner.next();
            System.out.println("podaj haslo");
            String password = scanner.next();
            if (register.logIn(login, password)) {
                System.out.println("zalogowano poprawnie");
                //todo przenieś uzytkownika do interfejsu uzytkownika
                break;
            }
            System.out.println("niepoprawny login lub haslo");
        }
    }

    private void shopLoop() {
        System.out.println("1 - logowanie");
        System.out.println("2 - rejestracja");
        Scanner scanner = new Scanner(System.in);
        int c;
        while ((c = scanner.nextInt()) != 1 && c != 2) {
            scanner.nextInt();
        }
        if (c == 1) {
            logInAccount();
        } else {
            createAccount();
        }
    }

    public static void main(String[] args) {
        ShopOnline shop = getInstance();
        shop.shopLoop();
    }
}