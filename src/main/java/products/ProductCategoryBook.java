package products;

import java.util.Date;

public class ProductCategoryBook implements Product {

    private String name;
    private String description;
    private double price;
    private int quantity;
    private String author;
    private Date releaseDate;


    @Override
    public void print() {
        System.out.println("name: " + name + "\n" +
                "description: " + description + "\n" +
                "price: " + price + "\n" +
                "quantity: " + quantity + "\n" +
                "author: " + author + "\n" +
                "release: " + releaseDate);
    }
}