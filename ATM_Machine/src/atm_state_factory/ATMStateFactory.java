package atm_state_factory;

import statePattern.*;

// ATM State Factory
// Factory Design Pattern
public class ATMStateFactory {
//    Singleton Design Patter
    final static ATMStateFactory instance = null;

    private ATMStateFactory() {}

    public static ATMStateFactory getInstance() {
        if(instance == null) {
            return new ATMStateFactory();
        }

        return instance;
    }

    public ATMState createIdleState() {
        return new IdleState();
    }

    public ATMState createHasCardState() {
        return new HasCardState();
    }

    public ATMState createSelectOperationState() {
        return new SelectOperationState();
    }

    public ATMState createTransactionState() {
        return new TransactionState();
    }
}
