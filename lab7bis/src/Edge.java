import java.util.ArrayList;

public class Edge {
    private Node node1;
    private Node node2;

    public Edge(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public Edge() {
        this.node1 = new Node(-1);
        this.node2 = new Node(-1);
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public void setNodes(Node node1, Node node2)
    {
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "Edge{" + node1.getNodeIndex() +
                ", " + node2.getNodeIndex() +
                '}';
    }
}
