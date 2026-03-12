package entities;

public class Cell {
    int row;
    int col;
    Symbol symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isCellEmpty(int row, int col) {
        return symbol == null;
    }
}
