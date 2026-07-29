package statePattern;

import atm_context.ATMMachineContext;

public class TransactionState implements ATMState {
    public TransactionState() {
        System.out.println("ATM in Transaction State");
    }

    @Override
    public String getStateName() {
        return "TransactionState";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() == null)
            return context.atmStateFactory.createIdleState();

//        After Transaction, Redirect to Select Operation State
        return context.atmStateFactory.createSelectOperationState();
    }
}
