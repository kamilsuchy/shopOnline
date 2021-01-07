package discount;

public class DefaultDiscount implements IDiscount {

    @Override
    public double calculateDiscount(double price) {
        return 0.99*price;
    }
}
