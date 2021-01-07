package loginAndRegister;


import account.CustomerAccount;
import account.FacadeAccount;
import account.UserState;
import webUsers.WebUsers;

import java.util.List;
import java.util.Scanner;

public class LogCommand implements Command {

    @Override
    public void execute() {
        logInAccount(WebUsers.getInstance().getAccountList());
    }

    private static void logInAccount(List<FacadeAccount> listOfAccounts) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("podaj login");
        String login = scanner.next();
        System.out.println("podaj haslo");
        String password = scanner.next();
        FacadeAccount account;
        if ((account = logIn(listOfAccounts, login, password)) != null) {
            if (isBanned((CustomerAccount) account)) {
                System.out.println("Nie mozna zalogowac. Uzytkownik zbanowany lub zablokowany");
                Register.logOrRegister();
            } else {
                System.out.println("zalogowano poprawnie");
                account.accountLoop();
            }
        } else {
            System.out.println("niepoprawny login lub haslo");
            Register.logOrRegister();
        }
    }

    private static boolean isBanned(CustomerAccount account) {
        return account.getClass() == CustomerAccount.class &&
                (account.getUserState() == UserState.BLOCKED ||
                        account.getUserState() == UserState.BANNED);
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