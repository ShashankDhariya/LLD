package entities;

public class Player {
    String name;
    Symbol symbol;

    public Player(String name,Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public Symbol getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
