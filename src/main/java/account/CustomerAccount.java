package account;

import order.Order;

import java.util.ArrayList;
import java.util.List;

public class CustomerAccount extends  Account{

    UserState userState;
    double balance;
    String email;
    List<Order> historyOfOrders;

    public CustomerAccount(String name, String surname, String login, String password, int userID,  String email) {
        super(name, surname, login, password, userID);
        this.userState = UserState.NEW;
        this.balance = 0;
        this.email = email;
        this.historyOfOrders = new ArrayList<>();
    }
}
