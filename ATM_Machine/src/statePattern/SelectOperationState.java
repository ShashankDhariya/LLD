package statePattern;

import atm_context.ATMMachineContext;

public class SelectOperationState implements ATMState {
    public SelectOperationState() {
        System.out.println("Transaction State, Please Select your Operation: ");
        System.out.println("Withdraw Cash");
        System.out.println("Check Balance");
    }


    @Override
    public String getStateName() {
        return "TransactionState";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() == null)
            return context.atmStateFactory.createIdleState();

        if(context.selectedOperation != null)
            return context.atmStateFactory.createSelectOperationState();
        return this;
    }
}
