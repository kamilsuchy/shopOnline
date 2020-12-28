package account;

import loginAndRegister.Register;
import offers.Offers;
import order.Order;
import products.Product;
import shoppingCart.ShoppingCart;


public abstract class Account implements FacadeAccount{
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

    @Override
    public ShoppingCart getCart() {
        return null;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public boolean subMoney(double money){return false;}

    @Override
    public void addToHistory(Order order){};

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

    public void setPassword(String password) {
        this.password = password;
    }

    public void printOffers() {
        Offers offers = Offers.getInstance();
        System.out.println("========OGLOSZENIA========");
        for (Product product : offers.getProductList()){
            product.print();
            System.out.println("========================");
        }
    }

    public void logout() {
        System.out.println("wylogowano poprawnie");
        Register.logOrRegister();
    }

    public abstract void accountLoop();

    public abstract void printOptions();
}
