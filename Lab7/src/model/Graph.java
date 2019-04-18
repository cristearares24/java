package model;

import java.util.ArrayList;

public class Graph {

    private int verticesNumber;

    private ArrayList<Edge> edgeList;

    public Graph(ArrayList<Edge> edgeList, int verticesNumber) {
        this.edgeList = new ArrayList<>(edgeList);
        this.verticesNumber = verticesNumber;
    }

    public Graph() {
        this.edgeList = new ArrayList<>();
        this.verticesNumber = 0;
    }

    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public int getVerticesNumber() { return this.verticesNumber; }

    public void setVerticesNumber(int n) { this.verticesNumber = n; }

    public void addEdge(Edge newEdge) { this.edgeList.add(newEdge); }

    public Edge pollFirst()
    {
        Edge extractedEdge = edgeList.get(0);
        edgeList.remove(0);
        return extractedEdge;
    }

    public boolean isSpanningTree()
    {
        ArrayList<Node> nodeFrequency = new ArrayList<>();

        for(int i = 0; i < this.verticesNumber; i++)
        {
            nodeFrequency.add(new Node(i));
        }
        for (Edge edge : this.edgeList)
        {
            nodeFrequency.get(edge.getNode1().getNodeIndex()).passIncrement();
        }

        for (Node node : nodeFrequency)
        {
            if(node.getNumberOfPasses() == 0)
                return false;
        }

        return true;
    }
}
