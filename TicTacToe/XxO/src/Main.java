import entities.Player;
import entities.Symbol;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Player1", Symbol.X);
        Player p2 = new Player("Player2", Symbol.O);

        Game game = new Game(p1, p2);

//      Take row and column as input to continue Game
    }
}