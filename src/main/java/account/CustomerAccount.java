package account;

import historyOfOrders.HistoryIterator;
import historyOfOrders.HistoryOfOrders;
import offerFactory.BookFactory;
import offerFactory.Factory;
import offers.Offers;
import products.*;

import java.util.Scanner;

public class CustomerAccount extends Account {

    UserState userState;
    double balance;
    String email;
    HistoryOfOrders historyOfOrders;

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public CustomerAccount(String name, String surname, String login, String password, int userID, String email) {
        super(name, surname, login, password, userID);
        this.userState = UserState.NEW;
        this.balance = 0;
        this.email = email;
        this.historyOfOrders = new HistoryOfOrders();
    }

    private void addMoney(double money) {
        this.balance += money;
    }

    private boolean subMoney(double money) {
        if (this.balance - money >= 0) {
            this.balance -= money;
            return true;
        }
        return false;
    }

    private void addMoneyToAccount() {
        System.out.println("ile pieniedzy chcesz wplacic");
        Scanner sc = new Scanner(System.in);
        while (true) {
            double money = sc.nextDouble();
            if (money > 0) {
                addMoney(money);
                System.out.println("Wplacono pomyslnie, Twoje saldo: " + this.balance);
                break;
            } else {
                System.out.println("wplacane pieniadze powinny byc liczba dodatnia");
            }
        }
    }

    private void addProduct(){
        Factory.create(this);
    }

    private void printHistory(){
        System.out.println("1 - wyświetl historię od najstarszych zamówień");
        System.out.println("2 - wyświetl historię od najnowszych zamówień");
        Scanner scanner = new Scanner(System.in);
        int c= scanner.nextInt();
        if (c == 1){
            printHistoryFromOldest();
        }else{
            printHistoryFromMostRecent();
        }
    }

    private void printHistoryFromOldest(){
        HistoryIterator iterator = historyOfOrders.getIterator();
        for (iterator.first(); !iterator.isLast(); iterator.next()) {
            iterator.currentOrder().printOrder();
        }
//        iterator.last().printOrder(); //TODO sprawdzic czy potrzebne
    }

    private void printHistoryFromMostRecent(){
        HistoryIterator iterator = historyOfOrders.getIterator();
        for (iterator.last(); !iterator.isFirst();iterator.prev()){
            iterator.currentOrder().printOrder();
        }
//        iterator.first().printOrder(); //TODO sprawdzic czy potrzebne
    }

    @Override
    public void printOptions(){
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - przegladaj oferty");
        System.out.println("2 - doladuj konto");
        System.out.println("3 - zobacz historie zamowien");
        System.out.println("4 - zmien dane konta");
        System.out.println("5 - dodaj ogloszenie");
        System.out.println("6 - wyloguj");
    }

    @Override
    public void accountLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printOptions();
            int c = scanner.nextInt();
            if (c == 1) {
                printOffers();
                //break;
            } else if (c == 2) {
                addMoneyToAccount();
                //break;
            } else if (c == 3) {
                printHistory();
                //break;
            } else if (c == 4) {
                //todo
                //break;
            }else if (c == 5){
                addProduct();
                //break;
            }else if (c == 6){
                logout();
                break;
            }
        }
    }
}