package statePattern;

import atm_context.ATMMachineContext;

public class IdleState implements ATMState {
    public IdleState() {
        System.out.println("ATM is in IDLE state, Please insert your card");
    }

    @Override
    public String getStateName() {
        return "Idle State";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() != null) {
            context.atmStateFactory.createIdleState();
        }

        return this;
    }


}
