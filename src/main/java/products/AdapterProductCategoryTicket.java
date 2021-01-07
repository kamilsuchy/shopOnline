package products;

import account.Account;
import account.FacadeAccount;

public class AdapterProductCategoryTicket extends ProductCategoryTicket  implements Product, Prototype {

    public AdapterProductCategoryTicket(String name, String event, String eventDate, double price, Account account) {
        super(name, event, eventDate, price, account);
    }

    private AdapterProductCategoryTicket(AdapterProductCategoryTicket ticket){
        super(ticket.name, ticket.event, ticket.eventDate, ticket.price, ticket.account);
    }

    @Override
    public void print() {
        wyswietl();
    }

    @Override
    public AdapterProductCategoryTicket clone(){
        return new AdapterProductCategoryTicket(this);
    }

    @Override
    public void setAll(FacadeAccount account) {
        ustaw();
    }

    @Override
    public String getName() {
        return nazwa();
    }

    @Override
    public String getCategory() {
        return kategoria();
    }

    @Override
    public double getPrice() {
        return cena();
    }

    @Override
    public int getQuantity() {
        return ilosc();
    }

    @Override
    public void setQuantity(int quantity) {}

    public FacadeAccount getAccount() {
        return konto();
    }

}