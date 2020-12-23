package offerFactory;

import account.Account;
import products.Product;
import products.ProductCategoryBook;

import java.util.Scanner;

public class BookFactory extends Factory{

    protected Product createOffer(Account account){
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj nazwe");
        String name = scanner.next();
        System.out.println("podaj opis");
        String description = scanner.next();
        System.out.println("podaj cene");
        double price = scanner.nextDouble();
        System.out.println("podaj ilosc");
        int quantity = scanner.nextInt();
        System.out.println("podaj autora");
        String author = scanner.next();
        System.out.println("podaj date");
        String release = scanner.next();
        return new ProductCategoryBook(name, description, price, quantity, author, release, account);
    }
}