package entities;

public class Board {
    int size;
    Cell[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new Cell[size][size];

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                grid[row][col] = new Cell(row, col);
            }
        }
    }

    public boolean isCellEmpty(int row, int col){
        return grid[row][col] == null;
    }

    public void setCell(int row, int col, Symbol symbol){
        grid[row][col].setSymbol(symbol);
    }
}
