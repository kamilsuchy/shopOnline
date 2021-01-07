package payment;

public abstract class Decorator implements IPayment{

    protected final IPayment payment;

    public Decorator(IPayment payment) {
        this.payment = payment;
    }
}
