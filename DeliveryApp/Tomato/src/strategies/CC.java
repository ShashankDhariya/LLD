package strategies;

public class CC implements PaymentStrategy {
    @Override
    public boolean Pay(double amount) {
        System.out.println("Paying " + amount);
        return true;
    }
}
