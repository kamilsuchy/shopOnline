package payment;

public class DefaultDecorator extends Decorator{

    public DefaultDecorator(IPayment payment) {
        super(payment);
    }

    @Override
    public void printBill() {
        payment.printBill();
        System.out.println("Zapraszamy ponownie");
    }
}
