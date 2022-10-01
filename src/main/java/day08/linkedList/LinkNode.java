package day08.linkedList;

public class LinkNode<T> {
    T data;
    LinkNode<T> next;

    public LinkNode() {
        next = null;
    }

    public LinkNode(T data) {
        this.data = data;
        next = null;
    }
}
