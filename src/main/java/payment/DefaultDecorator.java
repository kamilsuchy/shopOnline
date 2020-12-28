package payment;

public class DefaultDecorator extends Decorator{

    private final IPayment payment;

    public DefaultDecorator(IPayment payment) {
        this.payment = payment;
    }

    @Override
    public void printBill() {
        payment.printBill();
        System.out.println("Zapraszamy ponownie");
    }
}
