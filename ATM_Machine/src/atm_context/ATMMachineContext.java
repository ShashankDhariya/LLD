package atm_context;

import atm_state_factory.ATMStateFactory;
import entities.Account;
import entities.Card;
import entities.CashType;
import entities.TransactionType;
import inventory.ATMInventory;
import statePattern.*;

import java.util.HashMap;
import java.util.Map;

public class ATMMachineContext {
    private ATMState currentState;
    private Card currentCard;
    private Account currentAccount;
    private ATMInventory atmInventory;
    public Map<String, Account> accounts;   // Simplified Account Storage
    public ATMStateFactory atmStateFactory;
    public TransactionType selectedOperation;

    public ATMMachineContext() {
        this.atmStateFactory = ATMStateFactory.getInstance();
        this.currentState = atmStateFactory.createIdleState();
        this.atmInventory = new ATMInventory();
        this.accounts = new HashMap<>();
        System.out.println("ATMMachine Initialized with " + currentState.getStateName());
    }

//    Advance to next State
    public void advanceState() {
        ATMState nextState = currentState.next(this);
        currentState = nextState;
        System.out.println("Current State " + currentState.getStateName());
    }

//    Card insertion
    public void insertCard(Card card) {
        if(currentState instanceof IdleState) {
            System.out.println("Card inserted");
            this.currentCard = card;
            advanceState();
        }

        else {
            System.out.println("Card cannot be inserted in " + currentState.getStateName());
        }
    }

//    Pin Authentication
    public void enterPin(int pin) {
        if(currentState instanceof HasCardState) {
            if(currentCard.validateCardPin(pin)) {
                System.out.println("Pin Authenticated Successfully");
                advanceState();
            }

            else {
                System.out.println("Invalid Pin Entered");
            }
        }

        else
            System.out.println("Cannot enter Pin in " + currentState.getStateName());
    }

    public void selectOperation(TransactionType transactionType) {
        if(currentState instanceof SelectOperationState) {
            System.out.println("Selected Operation" + transactionType);
            this.selectedOperation = transactionType;
            advanceState();
        }

        else {
            System.out.println("Cannot select Operation in " + currentState.getStateName());
        }
    }

//    Perform Operation
    public void performOperation(double amount) {
        if(currentState instanceof TransactionState) {
            try {
                if(selectedOperation == TransactionType.WITHDRAW_CASH) {
                    performWithdrawal(amount);
                }else if(selectedOperation == TransactionType.CHECK_BALANCE) {
                    checkBalance();
                }

            }catch (Exception e) {
                System.out.println("Transaction Failed " + e.getMessage());

                currentState = atmStateFactory.createSelectOperationState();
            }
        }

        else {
            System.out.println("Cannot perform Operation in " + currentState.getStateName());
        }
    }

//    Return Card to User
    public void returnCard() {
        if(currentState instanceof HasCardState
                || currentState instanceof SelectOperationState
                || currentState instanceof TransactionState) {
            System.out.println("Card Returned to Customer");
            resetATM();
        }

        else {
            System.out.println("No Card to return in " + currentState.getStateName());
        }
    }

    public void performWithdrawal(double amount) {
//        User has sufficient funds
        if(!currentAccount.withdraw(amount)) {
            throw new RuntimeException("Insufficient Funds in Account to Withdraw");
        }

//        Inventory has sufficient funds
        if(!atmInventory.hasSufficientBalance((int) amount)) {
            currentAccount.deposit(amount);
            throw  new RuntimeException("Insufficient Funds in Inventory to Withdraw");
        }

        Map<CashType, Integer> dispensedCash = atmInventory.dispenseCash((int) amount);
        if(dispensedCash == null) {
            currentAccount.deposit(amount);
            throw  new RuntimeException("Unable to dispense exact Cash");
        }

        System.out.println("Transaction Successful, Please collect your cash");
        for(Map.Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
            System.out.println(entry.getValue() + " x Rs." + entry.getKey().value);
        }
    }

//    Check Balance
    void checkBalance() {
        System.out.println("Your current Balance in Account is " + currentAccount.getBalance());
    }

//    Reset ATM state
    void resetATM() {
        this.currentCard = null;
        this.currentAccount = null;
        this.selectedOperation = null;
        this.currentState = null;
    }

//    Getters and Setters
    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public ATMInventory getATMInventory() {
        return atmInventory;
    }

    public TransactionType getSelectedOperation() {
        return selectedOperation;
    }

    public ATMStateFactory getATMStateFactory() {
        return atmStateFactory;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
