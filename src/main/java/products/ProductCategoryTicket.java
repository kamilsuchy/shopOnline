package products;

import account.Account;
import account.FacadeAccount;

import java.util.Date;

public class ProductCategoryTicket implements InterfaceProduct {
    private final String name;
    private final String event;
    private final String eventDate;
    private final double price;
    private final FacadeAccount account;

    public ProductCategoryTicket(String name, String event, String eventDate, double price, Account account) {
        this.name = name;
        this.event = event;
        this.eventDate = eventDate;
        this.price = price;
        this.account = account;
    }

    @Override
    public void wyswietl() {
        System.out.println("category: " + "ticket" + "\n" +
                "name: " + name + "\n" +
                "event: " + event + "\n" +
                "date: " + eventDate + "\n" +
                "price: " + price);
    }

    public FacadeAccount getAccount() {
        return account;
    }
}