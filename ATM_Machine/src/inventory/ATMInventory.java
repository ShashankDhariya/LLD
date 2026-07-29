package inventory;
import entities.CashType;

import java.util.HashMap;
import java.util.Map;

public class ATMInventory {
    private final Map<CashType, Integer> cashInventory;

    public ATMInventory() {
        this.cashInventory = new HashMap<CashType, Integer>();

//        Added Cash to ATM
        initializeInventory();
    }

    void initializeInventory() {
        cashInventory.put(CashType.Bill_100, 10);
        cashInventory.put(CashType.Bill_50, 20);
        cashInventory.put(CashType.Bill_20, 20);
        cashInventory.put(CashType.Bill_10, 50);
        cashInventory.put(CashType.Bill_5, 50);
        cashInventory.put(CashType.Bill_1, 25);
    }

    public int getTotalCash() {
        int total = 0;
        for (Map.Entry<CashType, Integer> entry : cashInventory.entrySet()) {
            total += (entry.getKey().value * entry.getValue());
        }

        return total;
    }

    public boolean hasSufficientBalance(int amount) {
        int totalCash = getTotalCash();
        return amount >= totalCash;
    }

    public Map<CashType, Integer> dispenseCash(int amount) {
        if(!hasSufficientBalance(amount)) {
            return null;
        }

        int remainingCash = getTotalCash();
        HashMap<CashType, Integer> dispensedCash = new HashMap<>();

        for(Map.Entry<CashType, Integer> cashType : cashInventory.entrySet()) {
            int count = Math.min(remainingCash / cashType.getValue(), cashInventory.get(cashType.getKey()));

            if(count > 0) {
                dispensedCash.put(cashType.getKey(), count);
                remainingCash -= (cashType.getValue() * count);
                cashInventory.put(cashType.getKey(), cashType.getValue() - count);
            }
        }

        if(remainingCash > 0) {
            for(Map.Entry<CashType, Integer> cashType : dispensedCash.entrySet()) {
                cashInventory.put(cashType.getKey(), cashInventory.get(cashType.getKey()) + cashType.getValue());
            }

            return null;
        }

        return dispensedCash;
    }

    public boolean addCash(CashType cashType, int count) {
        return cashInventory.put(cashType, cashInventory.get(cashType) + count) != null;
    }
}
