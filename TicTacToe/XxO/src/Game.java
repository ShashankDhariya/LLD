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

    public void switchTurn() {
        if(currentPlayer.equals(player1))
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }
}
