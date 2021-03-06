package account;

import historyOfOrders.HistoryOfOrders;
import historyOfOrders.Iterator;
import offerFactory.Factory;
import offers.Offers;
import order.Order;
import products.Product;
import shoppingCart.ShoppingCart;



public class CustomerAccount extends Account {

    UserState userState;
    double balance;
    String email;
    HistoryOfOrders historyOfOrders;
    ShoppingCart cart;

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public CustomerAccount(String name, String surname, String login, String password, int userID, String email) {
        super(name, surname, login, password, userID);
        this.userState = UserState.NEW;
        this.balance = 0;
        this.email = email;
        this.historyOfOrders = new HistoryOfOrders();
        this.cart = new ShoppingCart(this);
    }

    @Override
    public void printOptions() {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - przeglądaj oferty");
        System.out.println("2 - doładuj konto");
        System.out.println("3 - zobacz historie zamówień");
        System.out.println("4 - rób zakupy");
        System.out.println("5 - dodaj ogłoszenie");
        System.out.println("6 - wyloguj");
    }

    @Override
    public void accountLoop() {
        while (true) {
            printOptions();
            int c = scanner.nextInt();
            if (c == 1) {
                printOffers();
            } else if (c == 2) {
                addMoneyToAccount();
            } else if (c == 3) {
                printHistory();
            } else if (c == 4) {
                doShopping();
            } else if (c == 5) {
                addProduct();
            } else if (c == 6) {
                logout();
                break;
            }
        }
    }

    @Override
    public void addMoney(double money) {
        this.balance += money;
    }

    private void addMoneyToAccount() {
        System.out.println("ile pieniedzy chcesz wplacic");
        while (true) {
            double money = scanner.nextDouble();
            if (money > 0) {
                addMoney(money);
                System.out.println("Wplacono pomyslnie, Twoje saldo: " + this.balance);
                break;
            } else {
                System.out.println("wplacane pieniadze powinny byc liczba dodatnia");
            }
        }
    }

    private void addProduct() {
        System.out.println("1 - dodaj nowe ogłoszenie");
        System.out.println("2 - dodaj ogłoszenie na podstawie innego");
        int c = scanner.nextInt();
        if (c == 1) {
            Factory.create(this);
        } else {
            templateOffer();
        }
    }

    private void templateOffer() {
        printOffers();
        System.out.println("Na podstawie, którego ogłoszenia chcesz stworzyć nowe");
        int c = scanner.nextInt();
        c--;
        System.out.println("wybrane ogłoszenie: ");
        Product product = Offers.getInstance().getProductList().get(c);
        product.print();
        Product newProduct = (Product) product.clone();
        newProduct.setAll(this);
        Offers.getInstance().addProduct(newProduct);
    }

    private void printHistory() {
        if (historyOfOrders.getSize() == 0) {
            System.out.println("Brak historii zamówień");
        } else {
            System.out.println("1 - wyświetl historię od najstarszych zamówień");
            System.out.println("2 - wyświetl historię od najnowszych zamówień");
            int c = scanner.nextInt();
            if (c == 1) {
                printHistoryFromOldest();
            } else {
                printHistoryFromMostRecent();
            }
        }
    }

    private void printHistoryFromOldest() {
        Iterator iter = historyOfOrders.getDefaultIterator();
        for (iter.first(); !iter.isLast(); iter.next()) {
            iter.currentOrder().printOrder();
        }
        iter.last().printOrder();
    }

    private void printHistoryFromMostRecent() {
        Iterator iter = historyOfOrders.getDefaultIterator();
        for (iter.last(); !iter.isFirst(); iter.prev()) {
            iter.currentOrder().printOrder();
        }
        iter.first().printOrder();
    }

    private void doShopping() {
        cart.doShopping();
    }

    @Override
    public boolean subMoney(double money) {
        if (this.balance - money >= 0) {
            this.balance -= money;
            return true;
        }
        return false;
    }

    @Override
    public void addToHistory(Order order) {
        historyOfOrders.addToHistory(order);
    }

    @Override
    public ShoppingCart getCart() {
        return cart;
    }

}