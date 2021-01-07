package products;

import account.FacadeAccount;

import java.util.Scanner;

public class ProductCategoryGame implements Product, Prototype {

    private String name;
    private String description;
    private String releaseDate;
    private double price;
    private FacadeAccount account;

    public ProductCategoryGame(String name, String description, String releaseDate, double price, FacadeAccount account) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.price = price;
        this.account = account;
    }

    private ProductCategoryGame(ProductCategoryGame game){
        this.name = game.name;
        this.description = game.description;
        this.releaseDate = game.releaseDate;
        this.price = game.price;
        this.account = game.account;
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

    @Override
    public ProductCategoryGame clone()  {
        return new ProductCategoryGame(this);
    }

    @Override
    public void setAll(FacadeAccount account) {
        System.out.println("czy chcesz zmienic nazwe? [1-TAK/2-NIE]");
        Scanner s = new Scanner(System.in);
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
        System.out.println("czy chcesz zmienić date wydania? [1-TAK/2-NIE]");
        c=s.nextInt();
        if (c == 1){
            System.out.println("podaj nową date wydania");
            releaseDate = s.next();
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
        return "Game";
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