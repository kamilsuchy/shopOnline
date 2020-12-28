package products;

import account.Account;
import account.FacadeAccount;

import java.util.Scanner;


public class ProductCategoryBook implements Product {

    private String name;
    private String description;
    private double price;
    private int quantity;
    private String author;
    private String releaseDate;
    private FacadeAccount account;

    public ProductCategoryBook(String name, String description, double price, int quantity, String author, String releaseDate, FacadeAccount account) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
        this.releaseDate = releaseDate;
        this.account = account;
    }

    private ProductCategoryBook(ProductCategoryBook book){
        this.name = book.name;
        this.description = book.description;
        this.price = book.price;
        this.quantity = book.quantity;
        this.author = book.author;
        this.releaseDate = book.releaseDate;
        this.account = book.account;
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

    public ProductCategoryBook clone(){
        return new ProductCategoryBook(this);
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
        System.out.println("czy chcesz zmienić opis? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nowy opis");
            description = s.next();
        }
        System.out.println("czy chcesz zmienić cene? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nową cene");
            price = s.nextDouble();
        }
        System.out.println("czy chcesz zmienić ilosc? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nową ilosc");
            quantity = s.nextInt();
        }
        System.out.println("czy chcesz zmienić autora? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nowego autora");
            author = s.next();
        }
        System.out.println("czy chcesz zmienić date wydania? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nową date wydania");
            releaseDate = s.next();
        }
        this.account = account;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCategory() {
        return "Book";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}