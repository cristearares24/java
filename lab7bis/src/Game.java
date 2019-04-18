import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private final List<Player> players = new ArrayList<>();
    private Player winner;

    public Game(Board board) {
        this.board = board;
        winner = new Player("Null", board.getComplete().getVerticesNumber());
    }

    public void addPlayer(Player player)
    {
        player.setGame(this);
        players.add(player);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void start()
    {
        for (Player player : players)
        {
            Thread newThread = new Thread(player);
            player.setThread(newThread);
            newThread.start();
//            while(winner.getName() == "Null")

        }
    }
}
