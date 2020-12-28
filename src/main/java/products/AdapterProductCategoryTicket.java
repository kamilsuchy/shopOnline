package products;

import account.Account;
import account.FacadeAccount;

import java.util.Scanner;

public class AdapterProductCategoryTicket extends ProductCategoryTicket  implements Product {

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

    public AdapterProductCategoryTicket clone(){
        return new AdapterProductCategoryTicket(this);
    }

    @Override
    public void setAll(FacadeAccount account) {
        Scanner s = new Scanner(System.in);
        System.out.println("czy chcesz zmienic nazwe? [1-TAK/2-NIE]");
        int c;
        c = s.nextInt();
        if (c == 1){
            System.out.println("podaj nowa nazwe");
            this.name = s.next();
        }
        System.out.println("czy chcesz zmienić wydarzenie? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nowy nazwe wydarzenia");
            event = s.next();
        }
        System.out.println("czy chcesz zmienić date wydarzenia? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nową date wydania");
            eventDate = s.next();
        }
        System.out.println("czy chcesz zmienić cene? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nową cene");
            price = s.nextDouble();
        }
        this.account = account;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCategory() {
        return "Ticket";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return 1;
    }

    @Override
    public void setQuantity(int quantity) {}


}