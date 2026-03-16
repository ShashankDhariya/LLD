package Payment;

public class Payment {
    double amount;
    PaymentStrategy paymentStrategy;

    public Payment(double amount, PaymentStrategy strategy) {
        this.amount = amount;
        this.paymentStrategy = strategy;
    }

    public void processPayment(double amount) {
        if (amount > 0)
            paymentStrategy.processPayment(amount);

        else
            System.out.println("Invalid amount");
    }
}
