package order;

import account.FacadeAccount;
import payment.Payment;
import products.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Order {

    private Map<Product, Integer> map;
    OrderStatus status;
    private final FacadeAccount account;

    public Order(List<Product> CartList, FacadeAccount account) {
        map = new HashMap<>();
        for (Product product : CartList) {
            map.put(product, 1);
        }
        this.account = account;
        status = OrderStatus.NEW;
    }

    public void printOrder() {
        System.out.println("====== ZAMÓWIENIE ======");
        int i = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            System.out.println("lp: " + (++i));
            entry.getKey().print();
            System.out.println("ilość: " + entry.getValue());
        }
    }

    private void changeQuantity(){
        Scanner s = new Scanner(System.in);
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            entry.getKey().print();
            System.out.println("ilość: " + entry.getValue());
            System.out.println("Czy chcesz zmienić ilość? [1 - NIE/2 - TAK]");
            int c = s.nextInt();
            if (c == 2){
                System.out.println("Podaj ilość");
                int quantity = s.nextInt();
                if (quantity >entry.getKey().getQuantity() ){
                    System.out.println("NIEPRAWIDŁOWA WARTOŚĆ");
                }else {
                    entry.setValue(quantity);
                }

            }
        }
    }

    private double calculateTotalPrice(){
        double sum = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()){
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    private void goToPayment(){
        Payment pay = new Payment(calculateTotalPrice(),this,account );
        pay.paymentLoop();
    }

    private void printOptions(){
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - wyświetl zamówienie");
        System.out.println("2 - ustaw ilość");
        System.out.println("3 - zapłać");
    }

    public void orderLoop() {

        Scanner s = new Scanner(System.in);

        while (true) {
            printOptions();
            int c = s.nextInt();
            if (c == 1){
                printOrder();
            }else if (c == 2){
                changeQuantity();
            }else if (c == 3){
                goToPayment();
                break;
            }
        }
    }

    public Map<Product, Integer> getMap(){
        return map;
    }

}