package account;

import offers.Offers;
import products.Product;
import webUsers.WebUsers;

import java.util.List;
import java.util.Scanner;

public class AdminAccount extends Account {


    public AdminAccount(String name, String surname, String login, String password, int userID) {
        super(name, surname, login, password, userID);
    }

    public void changeStatus() {
        System.out.println("podaj login użytkownika ktoremu chcesz zmienic status");
        CustomerAccount account = findAccount(scanner.next());

        if (account == null) {
            System.out.println("nie ma takiego uzytkownika lub nie można zmienić stanu temu uzytkownikowi");
        } else {
            printStates();
            change(account);
        }
    }

    private void change(CustomerAccount account){

        int c = scanner.nextInt();
        if (c == 1) {
            account.setUserState(UserState.NEW);
            System.out.println("zmieniono status uzytkownika na: NEW");
        } else if (c == 2) {
            account.setUserState(UserState.ACTIVE);
            System.out.println("zmieniono status uzytkownika na: ACTIVE");
        } else if (c == 3) {
            account.setUserState(UserState.BLOCKED);
            System.out.println("zmieniono status uzytkownika na: BLOCKED");
        } else if (c == 4) {
            account.setUserState(UserState.BANNED);
            System.out.println("zmieniono status uzytkownika na: BANNED");
        } else {
            System.out.println("nie zmieniono statusu");
        }
    }

    private CustomerAccount findAccount(String log){
        CustomerAccount account = null;
        List<FacadeAccount> users = WebUsers.getInstance().getAccountList();
        for (FacadeAccount user : users) {
            if (user.getLogin().equals(log) && user.getClass() == CustomerAccount.class) {
                account = (CustomerAccount) user;
            }
        }
        return account;
    }

    private void deleteOffer(){
        int i=0;
        List<Product> list = Offers.instance.getProductList();
        if (list.size() == 0){
            System.out.println("BRAK OFERT");
        }else{
            for (Product p : list){
                System.out.println("NR OFERTY: " + i);
                i++;
                p.print();
            }
            System.out.println("Którą oferte chcesz usunąć");
            int c = scanner.nextInt();
            Offers.getInstance().removeProduct(list.get(c));
        }
    }

    @Override
    public void printOptions() {
        System.out.println("[ADMIN] Co chcesz zrobić?");
        System.out.println("1 - zmien status uzytkownika");
        System.out.println("2 - usuń ogłoszenie");
        System.out.println("3 - wyloguj");
    }

    @Override
    public void accountLoop() {
        while (true) {
            printOptions();
            int c = scanner.nextInt();
            if (c == 1) {
                changeStatus();
            }else if (c == 2){
                deleteOffer();
            } else if (c == 3) {
                logout();
                break;
            }
        }
    }

    private void printStates(){
        System.out.println("podaj na jaki status chcesz zmienić status uzytkownika");
        System.out.println("1 - NEW");
        System.out.println("2 - ACTIVE");
        System.out.println("3 - BLOCKED");
        System.out.println("4 - BANNED");
    }
}