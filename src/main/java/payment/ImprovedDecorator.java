package payment;

public class ImprovedDecorator extends Decorator{

    private final IPayment payment;

    public ImprovedDecorator(IPayment payment) {
        this.payment = payment;
    }

    @Override
    public void printBill() {
        payment.printBill();
        System.out.println("Dziękujemy za zakupy. Zapraszamy Ponownie");
    }
}
