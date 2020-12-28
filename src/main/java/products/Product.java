package products;

import account.FacadeAccount;

public interface Product {

    void print();

    Object clone();

    void setAll(FacadeAccount account);

    String getName();

    String getCategory();

    double getPrice();

    int getQuantity();

    void setQuantity(int quantity);

    FacadeAccount getAccount();
}