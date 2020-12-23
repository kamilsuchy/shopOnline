package offerFactory;

import account.Account;
import products.Product;
import products.ProductCategoryGame;

import java.util.Scanner;

public class GameFactory extends Factory {

    protected Product createOffer(Account account){
        System.out.println("podaj nazwe");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("podaj opis");
        String description = scanner.next();
        System.out.println("podaj date wydania");
        String release = scanner.next();
        System.out.println("podaj cene");
        double price = scanner.nextDouble();
        return new ProductCategoryGame(name, description, release, price, account);
    }
}