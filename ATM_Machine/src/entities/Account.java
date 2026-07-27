package entities;

public class Account {
    private String accontNumber;
    private double balance;

    public Account(String accontNumber, double balance) {
        this.accontNumber = accontNumber;
        this.balance = balance;
    }

    String getAccontNumber() {
        return accontNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            return true;
        }

        return false;
    }
}
