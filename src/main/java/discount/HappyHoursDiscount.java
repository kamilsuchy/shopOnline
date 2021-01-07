package discount;

public class HappyHoursDiscount implements IDiscount {


    @Override
    public double calculateDiscount(double price) {
        if (price > 250){
            return 0.8 * price;
        }else{
            return 0.95* price;
        }
    }
}
