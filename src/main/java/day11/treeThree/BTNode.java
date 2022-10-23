package day11.treeThree;

public class BTNode<T> {
    T data;
    BTNode lchild;
    BTNode rchild;

    public BTNode() {
        lchild = rchild = null;
    }

    public BTNode(T d) {
        data = d;
        lchild = rchild = null;
    }
}
