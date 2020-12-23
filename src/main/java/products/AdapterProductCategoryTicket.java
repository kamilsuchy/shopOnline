package products;

import account.Account;

public class AdapterProductCategoryTicket extends ProductCategoryTicket  implements Product {

    public AdapterProductCategoryTicket(String name, String event, String eventDate, double price, Account account) {
        super(name, event, eventDate, price, account);
    }

    @Override
    public void print() {
        wyswietl();
    }
}