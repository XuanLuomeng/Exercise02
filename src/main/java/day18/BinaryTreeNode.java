package day18;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode father;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
        this.father = null;
        this.left = null;
        this.right = null;
        this.data = 0;
    }

    public BinaryTreeNode(int data) {
        this.father = null;
        this.left = null;
        this.right = null;
        this.data = data;
    }
}
