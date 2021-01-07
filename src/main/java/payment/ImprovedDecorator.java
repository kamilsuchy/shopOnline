package payment;

public class ImprovedDecorator extends Decorator{

    public ImprovedDecorator(IPayment payment) {
        super(payment);
    }

    @Override
    public void printBill() {
        payment.printBill();
        System.out.println("Dziękujemy za zakupy. Zapraszamy Ponownie");
    }
}
