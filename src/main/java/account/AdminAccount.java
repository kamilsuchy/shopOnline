package account;

import webUsers.WebUsers;

import java.util.List;
import java.util.Scanner;

public class AdminAccount extends Account  {


    public AdminAccount(String name, String surname, String login, String password, int userID) {
        super(name, surname, login, password, userID);
    }

    public void changeStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj login użytkownika ktoremu chcesz zmienic status");
        String login = scanner.next();
        CustomerAccount account = null;
        List<FacadeAccount> users = WebUsers.getInstance().getAccountList();
        for (FacadeAccount user : users){
            if (user.getLogin().equals(login) && user.getClass() == CustomerAccount.class){
                account = (CustomerAccount) user;
            }
        }
        if (account == null){
            System.out.println("nie ma takiego uzytkownika lub nie można zmienić stanu temu uzytkownikowi");
        }else{
            System.out.println("podaj na jaki status chcesz zmienić status uzytkownika");
            System.out.println("1 - NEW");
            System.out.println("2 - ACTIVE");
            System.out.println("3 - BLOCKED");
            System.out.println("4 - BANNED");
            int c = scanner.nextInt();
            if (c == 1){
                account.setUserState(UserState.NEW);
                System.out.println("zmieniono status uzytkownika na: NEW");
            }else if (c == 2){
                account.setUserState(UserState.ACTIVE);
                System.out.println("zmieniono status uzytkownika na: ACTIVE");
            }else if (c == 3){
                account.setUserState(UserState.BLOCKED);
                System.out.println("zmieniono status uzytkownika na: BLOCKED");
            }else if (c == 4){
                account.setUserState(UserState.BANNED);
                System.out.println("zmieniono status uzytkownika na: BANNED");
            }else{
                System.out.println("nie zmieniono statusu");
            }
        }

    }

    @Override
    public void printOptions(){
        System.out.println("[ADMIN] Co chcesz zrobić?");
        System.out.println("1 - zmien status uzytkownika");

        System.out.println("2 - wyloguj");
    }

    @Override
    public void accountLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printOptions();
            int c = scanner.nextInt();
            if (c == 1){
                changeStatus();
            }else if (c == 2){
                logout();
                break;
            }
        }
    }
}