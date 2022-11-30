package week2.day11.treeOne;

public class TSBNode<T> {
    T data;
    TSBNode<T>[] sons;

    public TSBNode(T data) {
        this.data = data;
        this.sons = null;
    }

    public void setSons(T[] sons) {
        this.sons = new TSBNode[sons.length];
        for (int i = 0; i < sons.length; i++) {
            this.sons[i] = new TSBNode<>(sons[i]);
        }
    }
}
