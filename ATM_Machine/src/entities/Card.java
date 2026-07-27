package entities;

public class Card {
    private String cardNumber;
    private int pin;
    private String accountNumber;

    public Card(String cardNumber, int pin, String accountNumber) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    String getCardNumber() {
        return cardNumber;
    }

    boolean validateCardPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    String getAccountNumber() {
        return accountNumber;
    }
}
