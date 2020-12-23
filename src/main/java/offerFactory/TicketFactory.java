package offerFactory;

import account.Account;
import products.AdapterProductCategoryTicket;
import products.Product;

import java.util.Scanner;

public class TicketFactory extends Factory{

    protected Product createOffer(Account account){
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj nazwe");
        String name = scanner.next();
        System.out.println("podaj wydarzenie");
        String event = scanner.next();
        System.out.println("podaj date");
        String date = scanner.next();
        System.out.println("podaj cene");
        double price = scanner.nextDouble();
        return new AdapterProductCategoryTicket(name, event, date, price, account);
    }
}