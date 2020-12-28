package products;

import account.Account;
import account.FacadeAccount;


public class ProductCategoryTicket implements InterfaceProduct {
    protected String name;
    protected String event;
    protected String eventDate;
    protected double price;
    protected FacadeAccount account;

    public ProductCategoryTicket(String name, String event, String eventDate, double price, FacadeAccount account) {
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