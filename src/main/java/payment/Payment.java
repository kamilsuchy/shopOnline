package payment;

import discount.IDiscount;

public class Payment {
    private IDiscount discount;
    private double priceBeforeDiscount;
    private double priceAfterDiscount;

    public void setDiscount(IDiscount discount) {
        this.discount = discount;
    }

    public void calculatePriceAfterDiscount(IDiscount discount, double priceBeforeDiscount){
        priceAfterDiscount = discount.calculateDiscount(priceBeforeDiscount);
    }

}