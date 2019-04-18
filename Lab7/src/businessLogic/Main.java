package businessLogic;

import model.Board;
import model.Edge;
import model.Graph;
import model.Player;

public class Main {

    public static void main(String[] args)
    {
        Player player1 = new Player("AD", 7);
        Player player2 = new Player("UN", 7);

        Board board = new Board(7);


        Game game = new Game(board);

        game.addPlayer(player1);
        game.addPlayer(player2);


        game.start();
    }
}
