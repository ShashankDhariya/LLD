import atm_context.ATMMachineContext;
import entities.Account;
import entities.Card;
import entities.TransactionType;

public class Main {
    public static void main(String[] args) {
        ATMMachineContext atm = new ATMMachineContext();

        atm.addAccount(new Account("11234343", 100000));
        atm.addAccount(new Account("11534343", 10000));

        try {
            System.out.println("<<<<<<<<<<<<<<< Starting ATM Demo >>>>>>>>>>>>>>>>>");

            atm.insertCard(new Card("123432", 1234, "11234343"));
            atm.enterPin(1234);
            atm.selectOperation(TransactionType.WITHDRAW_CASH);
            atm.performOperation(100.0);

            atm.selectOperation(TransactionType.CHECK_BALANCE);
            atm.performOperation(0.0);

            atm.returnCard();

            System.out.println("<<<<<<<<< ATM Demo Completed >>>>>>>>>>");

        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
}