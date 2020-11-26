package account;

import WebUsers.WebUsers;
import loginAndRegister.Register;
import order.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerAccount extends Account implements FacadeCustomerAccount{

    UserState userState;
    double balance;
    String email;
    List<Order> historyOfOrders;

    public CustomerAccount(String name, String surname, String login, String password, int userID, String email) {
        super(name, surname, login, password, userID);
        this.userState = UserState.NEW;
        this.balance = 0;
        this.email = email;
        this.historyOfOrders = new ArrayList<>();
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

    private void logout() {
        System.out.println("wylogowano poprawnie");
        Register.logOrRegister();
    }

    @Override
    public void accountLoop() {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - przegladaj oferty");
        System.out.println("2 - doladuj konto");
        System.out.println("3 - zobacz historie zamowien");
        System.out.println("4 - zmien dane konta");
        System.out.println("5 - dodaj ogloszenie");
        System.out.println("6 - wyloguj");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int c = scanner.nextInt();
            if (c == 1) {
                printOffers();
                break;
            } else if (c == 2) {
                addMoneyToAccount();
                break;
            } else if (c == 3) {
                //todo
                break;
            } else if (c == 4) {
                //todo
                break;
            }else if (c == 5){
                //todo
                break;
            }else if (c == 6){
                logout();
                break;
            }
        }
    }


}
