package offerFactory;

import account.Account;
import offers.Offers;
import products.Product;

import java.util.Scanner;

public abstract class Factory {

    protected abstract Product createOffer(Account account);

    public static void create(Account account){
        System.out.println("wybierz kategorie: ");
        System.out.println("1 - Book");
        System.out.println("2 - Game");
        System.out.println("3 - Ticket");

        Scanner scanner = new Scanner(System.in);
        Factory factory;
        int category = scanner.nextInt();
        Offers offers = Offers.getInstance();

        if (category == 1){
            factory = new BookFactory();
            Product product = factory.createOffer(account);
            offers.addProduct(product);
        }else if (category == 2){
            factory = new GameFactory();
            Product product = factory.createOffer(account);
            offers.addProduct(product);
        }else{
            factory = new TicketFactory();
            Product product = factory.createOffer(account);
            offers.addProduct(product);
        }
        System.out.println("ogłoszenie dodane poprawnie");
    }
}