package account;

import offers.Offers;
import products.Product;


public abstract class Account {
    String name;
    String surname;
    String login;
    String password;
    int userID;

    public Account(String name, String surname, String login, String password, int userID) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void printOffers() {
        Offers offers = Offers.getInstance();
        for (Product product : offers.getProductList()){
            product.print();
        }
    }

    public abstract void accountLoop();
}
