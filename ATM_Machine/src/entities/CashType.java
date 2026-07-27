package entities;

public enum CashType {
    Bill_100(100),
    Bill_50(50),
    Bill_20(20),
    Bill_10(10),
    Bill_5(5),
    Bill_1(1);

    public final int value;

    CashType(int value) {
        this.value = value;
    }
}
