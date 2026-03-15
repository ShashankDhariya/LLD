package Payment;

public class Card implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        
        System.out.println("Card Payment of Rs." + amount + " completed");
    }
}
