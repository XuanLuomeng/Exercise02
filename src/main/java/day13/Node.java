package day13;

public class Node {
    String date;
    double weight;
    public Node parent;
    Node left;
    Node right;
    boolean flag;

    public Node() {
        parent = null;
        left = null;
        right = null;
    }

    public double getWeight() {
        return weight;
    }
}
