package Payment;

public class Cash implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {

        System.out.println("Cash Payment of Rs." + amount + " completed");
    }
}
