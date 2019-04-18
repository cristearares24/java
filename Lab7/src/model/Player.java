package model;

import businessLogic.Game;


public class Player implements Runnable{

    private String name;
    private Graph graph;
    private Thread thread;
    private Game game;
    public static final int THINKING_TIME = 3;

    public Player(String name, int verticesNumber)
    {
        this.name = name;
        graph = new Graph();
        this.graph.setVerticesNumber(verticesNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private boolean play() throws InterruptedException
    {
        Board board = game.getBoard();
        if(board.isEmpty()) {return false;}
        this.graph.addEdge(board.extract());
        Thread.sleep(THINKING_TIME);
        if(graph.isSpanningTree())
            game.setWinner(this);

        return true;
    }


    public void run()
    {
        try
        {
            if(play() == false)
                Thread.currentThread().interrupt();
            System.out.println("Player " + this.name + " has extracted edge " + this.graph.getEdgeList().get(this.graph.getEdgeList().size() - 1) + "\n");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.print("Interrupted\n");
        }

    }

    @Override
    public String toString() {

        String output = "Player " + this.name + " with Graph\n";

        for(Edge edge : this.graph.getEdgeList())
        {
            output += edge.getNode1() + " -> " + edge.getNode2() + "\n";
        }

        return output;
    }
}
