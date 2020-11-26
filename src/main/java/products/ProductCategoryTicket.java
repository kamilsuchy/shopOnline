package products;

import java.util.Date;

public class ProductCategoryTicket implements InterfaceProduct {
    private String name;
    private String event;
    private Date eventDate;
    private double price;

    @Override
    public void wyswietl() {
        System.out.println("name: " + name + "\n" +
                "event: " + event + "\n" +
                "date: " + eventDate + "\n" +
                "price: " + price);
    }
}