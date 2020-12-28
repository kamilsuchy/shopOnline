package account;

import order.Order;
import shoppingCart.ShoppingCart;

public interface FacadeAccount {

     void accountLoop();

     String getLogin();

     String getPassword();

     boolean subMoney(double money);

     void addToHistory(Order order);

     ShoppingCart getCart();

     void addMoney(double money);
}