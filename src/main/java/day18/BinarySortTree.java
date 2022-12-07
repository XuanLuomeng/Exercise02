package day18;

public class BinarySortTree {
    public static void main(String[] args) {
        int[] arrays = {15, 7, 17, 32, 3, 42, 8, 9, 16, 1};
        BinaryTree binaryTree = new BinaryTree(arrays);
        binaryTree.show(binaryTree.root);
        System.out.println();
        binaryTree.deleteNode(7);
        binaryTree.show(binaryTree.root);
    }
}
