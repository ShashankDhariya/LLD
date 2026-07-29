package statePattern;

import atm_context.ATMMachineContext;

public class HasCardState implements ATMState {
    public HasCardState() {
        System.out.println("ATM Has Card State, Please Enter your PIN");
    }


    @Override
    public String getStateName() {
        return "HasCardState";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() == null)
            return context.atmStateFactory.createIdleState();

        if(context.getCurrentAccount() != null)
            return context.atmStateFactory.createSelectOperationState();

        return null;
    }
}
