package products;

import account.Account;
import account.FacadeAccount;


public class ProductCategoryBook implements Product {

    private final String name;
    private final String description;
    private final double price;
    private final int quantity;
    private final String author;
    private final String releaseDate;
    private final FacadeAccount account;

    public ProductCategoryBook(String name, String description, double price, int quantity, String author, String releaseDate, Account account) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
        this.releaseDate = releaseDate;
        this.account = account;
    }

    @Override
    public void print() {
        System.out.println("category: " + "book" + "\n" +
                "name: " + name + "\n" +
                "description: " + description + "\n" +
                "price: " + price + "\n" +
                "quantity: " + quantity + "\n" +
                "author: " + author + "\n" +
                "release: " + releaseDate);
    }

    public FacadeAccount getAccount() {
        return account;
    }
}