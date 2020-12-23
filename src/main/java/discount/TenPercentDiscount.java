package discount;

public class TenPercentDiscount implements IDiscount {

    @Override
    public double calculateDiscount(double price) {
        return 0.9*price;
    }

}