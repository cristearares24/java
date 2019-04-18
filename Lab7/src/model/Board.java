package model;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private final Graph complete;

    public Board(int verticesNumber) {
        complete = new Graph();
        this.complete.setVerticesNumber(verticesNumber);
        for(int i = 0; i < verticesNumber; i++)
            for(int j = 0; j < verticesNumber; j++)
            if(i != j)
            {

                Edge newEdge = new Edge(new Node(i), new Node(j));
                this.complete.addEdge(newEdge);
            }

        ArrayList<Edge> shuffledEdgeList = new ArrayList<Edge>(this.complete.getEdgeList());

        Collections.shuffle(shuffledEdgeList);

        this.complete.setEdgeList(shuffledEdgeList);
    }

    public Graph getComplete() {
        return complete;
    }

    public synchronized Edge extract()
    {
        Edge edge = complete.pollFirst();
        return edge;
    }

    public boolean isEmpty() { return this.complete.getEdgeList().isEmpty(); }
}
