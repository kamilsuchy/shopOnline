package products;

import account.FacadeAccount;

import java.util.Scanner;


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


    @Override
    public void ustaw() {
        Scanner s = new Scanner(System.in);
        System.out.println("czy chcesz zmienic nazwe? [1-TAK/2-NIE]");
        int c = s.nextInt();
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
    public String nazwa() {
        return this.name;
    }

    @Override
    public String kategoria() {
        return "Ticket";
    }

    @Override
    public double cena() {
        return price;
    }

    @Override
    public int ilosc() {
        return 1;
    }

    @Override
    public void ustawIlosc() {}

    @Override
    public FacadeAccount konto() {
        return account;
    }
}