package day12;

public class TreeNode {
    String data;
    TreeNode fatherTree;
    TreeNode lifeTree;
    TreeNode rightTree;

    public TreeNode(String data) {
        this.data = data;
        this.fatherTree = null;
        lifeTree = null;
        rightTree = null;
    }
}
