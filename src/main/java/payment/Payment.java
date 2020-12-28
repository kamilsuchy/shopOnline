package payment;

import account.FacadeAccount;
import discount.HappyHoursDiscount;
import discount.IDiscount;
import discount.TenPercentDiscount;
import offers.Offers;
import order.Order;
import products.Product;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Payment implements IPayment {

    private IDiscount discount;
    private double priceBeforeDiscount;
    private double priceAfterDiscount;
    private Order order;
    private FacadeAccount account;


    public Payment(double priceBeforeDiscount, Order order, FacadeAccount account) {
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.order = order;
        this.account = account;
    }

    private void setDiscount(IDiscount discount) {
        this.discount = discount;
    }

    public void calculatePriceAfterDiscount(double priceBeforeDiscount) {
        priceAfterDiscount = discount.calculateDiscount(priceBeforeDiscount);
    }

    private void serviceDiscount() {
        System.out.println("podaj kod");
        Scanner s = new Scanner(System.in);
        String code = s.next();
        if (code.equals("10PERCENT")) {
            setDiscount(new TenPercentDiscount());
            System.out.println("KOD POPRAWNY");
        } else if (code.equals("HAPPY")) {
            setDiscount(new HappyHoursDiscount());
            System.out.println("KOD POPRAWNY");
        } else {
            System.out.println("NIEPOPRAWNY KOD");
        }
    }

    private void pay() {

        if (account.subMoney(priceAfterDiscount)) {
            System.out.println("Płatność zakończona pomyślnie");
            account.addToHistory(order);
            Decorator decorator;
            if (priceAfterDiscount > 200) {
                decorator = new ImprovedDecorator(this);
            } else {
                decorator = new DefaultDecorator(this);
            }
            decorator.printBill();
            account.getCart().resetCart();
            Map<Product, Integer> productIntegerMap = order.getMap();
            for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
                entry.getKey().getAccount().addMoney(entry.getKey().getPrice() * entry.getValue());
                deleteFromListProduct(entry.getKey().getName(), entry.getValue());
            }


        } else {
            System.out.println("Nie można zrealizować płatności");
        }
    }

    private void deleteFromListProduct(String name, int quantity) {
        List<Product> productList = Offers.getInstance().getProductList();
        for (Product product : productList){
            if (product.getName().equals(name)){
                if (product.getQuantity() == quantity){
                    Offers.getInstance().removeProduct(product);
                }else{
                    Offers.getInstance().setQuantity(product, product.getQuantity() - quantity);
                }
            }
        }
    }


    public void paymentLoop() {
        System.out.println("Czy posiadasz kod rabatowy? [1 - TAK / 2 - NIE]");
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        if (c == 1) {
            serviceDiscount();
        }
        calculatePriceAfterDiscount(priceBeforeDiscount);
        System.out.println("WARTOŚĆ ZAMÓWIENIA: " + priceBeforeDiscount);
        System.out.println("WARTOŚĆ RABATU: " + (priceBeforeDiscount - priceAfterDiscount));
        System.out.println("DO ZAPLATY: " + priceAfterDiscount);
        System.out.println("1 - zapłać/2 - anuluj zamówienie");
        c = s.nextInt();
        if (c == 1) {
            pay();
        } else if (c == 2) {
            //todo
        }
    }

    public void printBill() {
        System.out.println("RACHUNEK");
        order.printOrder();
        System.out.println("WARTOŚĆ ZAMÓWIENIA: " + priceBeforeDiscount);
        System.out.println("WARTOŚĆ RABATU: " + (priceBeforeDiscount - priceAfterDiscount));
        System.out.println("DO ZAPLATY: " + priceAfterDiscount);
    }
}