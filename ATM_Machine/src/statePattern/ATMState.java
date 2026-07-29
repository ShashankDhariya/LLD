package statePattern;

import atm_context.ATMMachineContext;

// Base ATM state interface
public interface ATMState {

//    Current State
    String getStateName();

//    Method to handle ATM State transitions
    ATMState next(ATMMachineContext context);
}
