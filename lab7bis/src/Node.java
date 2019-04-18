public class Node {

    private int nodeIndex;
    private int numberOfPasses;

    public Node(int nodeIndex) {
        this.nodeIndex = nodeIndex;
        this.numberOfPasses = 0;
    }

    public Node() {
        this.nodeIndex = -1;
        this.numberOfPasses = 0;
    }

    public int getNodeIndex() {
        return nodeIndex;
    }

    public void setNodeIndex(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    public int getNumberOfPasses() {
        return numberOfPasses;
    }

    public void passIncrement()
    {
        this.numberOfPasses++;
    }
}
