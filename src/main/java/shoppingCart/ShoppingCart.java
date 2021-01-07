package shoppingCart;

import account.FacadeAccount;
import offers.Offers;
import order.Order;
import products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    private List<Product> listOfProductsInCart;
    private final List<Product> allOffers;
    private final FacadeAccount account;

    public ShoppingCart(FacadeAccount account) {
        this.listOfProductsInCart = new ArrayList<>();
        this.allOffers = Offers.getInstance().getProductList();
        this.account = account;
    }

    public void printOptions(){
        System.out.println("Co chcesz zrobić:");
        System.out.println(" 1 - wyszukaj produkt po nazwie");
        System.out.println(" 2 - wyszukaj produkt po kategorii");
        System.out.println(" 3 - wyświetl wszystkie produkty");
        System.out.println(" 4 - dodaj do koszyka");
        System.out.println(" 5 - wyświetl koszyk");
        System.out.println(" 6 - przejdź do kasy");
        System.out.println(" 7 - zakończ zakupy");
    }

    public void doShopping(){

        Scanner s = new Scanner(System.in);
        while (true){
            printOptions();
            int c = s.nextInt();
            if (c == 1){
                System.out.println("podaj nazwe");
                searchByName(s.next());
            }else if (c == 2){
                System.out.println("wybierz kategorie");
                System.out.println("1 - Book");
                System.out.println("2 - Game");
                System.out.println("3 - Ticket");
                searchByCategory(s.nextInt());
            }else if (c == 3){
                displayAllOffers();
            }
            else if (c == 4){
                System.out.println("podaj numer oferty");
                addProductToCartByNumber(s.nextInt());
            }else if (c == 5){
                displayCart();
            }else if (c == 6){
                shoppingCartApproval();
                break;
            }else if (c == 7){
                break;
            }
        }
    }

    public void resetCart(){
        listOfProductsInCart = new ArrayList<>();
    }

    private void searchByCategory(int category){
        int i = 0;
        String c;
        if(category == 1){
            c = "Book";
        }else if (category == 2){
            c = "Game";
        }else {
            c = "Ticket";
        }

        for (Product product : allOffers) {
            if (product.getCategory().equals(c)) {
                System.out.println("NUMER OFERTY: " + i);
                product.print();
            }
            i++;
        }
    }

    private void searchByName(String name) {
        int i = 0;

        for (Product product : allOffers) {
            if (product.getName().startsWith(name)) {
                System.out.println("NUMER OFERTY: " + i);
                product.print();
            }
            i++;
        }
    }

    private void displayAllOffers() {
        int i = 0;
        for (Product product : allOffers) {
            System.out.println("NUMER OFERTY: " + i);
            product.print();
            i++;
        }
    }

    private void addProductToCart(Product product) {
        listOfProductsInCart.add(product);
    }

    private void addProductToCartByNumber(int n) {
        if (n < allOffers.size()){
            addProductToCart(allOffers.get(n));
            System.out.println("pomyślnie dodany do koszyka");
        }else{
            System.out.println("nieprawidłowa wartość");
        }
    }

    private void displayCart() {
        System.out.println("w koszyku");
        for (Product p : listOfProductsInCart) {
            p.print();
            System.out.println();
        }
    }

    private void shoppingCartApproval() {
        Order order = new Order(listOfProductsInCart, account);
        order.orderLoop();
    }

}