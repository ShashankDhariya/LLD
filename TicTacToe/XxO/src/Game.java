import entities.Board;
import entities.Player;

public class Game {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new Board(3);
    }

    public int move(int row, int col, Player player) {
        if(row < 0 || row > 3 || col < 0 || col > 3)
            throw new IllegalArgumentException("Invalid move");

        else if(!board.isCellEmpty(row, col))
            throw new IllegalArgumentException("Invalid move");

        else if(player == null)
            throw new IllegalArgumentException("Invalid Player");

        else {
            board.setCell(row, col, currentPlayer.getSymbol());

//            checkIfWon(board);
        }

        return -1;
    }

    public void switchTurn() {
        if(currentPlayer.equals(player1))
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }
}
