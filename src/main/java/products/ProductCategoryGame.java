package products;

import account.Account;
import account.FacadeAccount;

public class ProductCategoryGame implements Product {

    private final String name;
    private final String description;
    private final String releaseDate;
    private final double price;
    private final FacadeAccount account;

    public ProductCategoryGame(String name, String description, String releaseDate, double price, Account account) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.price = price;
        this.account = account;
    }

    @Override
    public void print() {
        System.out.println("category: " + "game" + "\n" +
                "name: " + name + "\n" +
                "description: " + description + "\n" +
                "release date: " + releaseDate + "\n" +
                "price: " + price);
    }

    public FacadeAccount getAccount() {
        return account;
    }
}
