package week2.day10;

/**
 * Initialization and assignment of each object
 * @param <T>
 */
public class LinkNode<T> {
    T data;
    LinkNode<T> next;

    public LinkNode() {
        next = null;
    }

    public LinkNode(T d) {
        this.data = d;
        this.next = null;
    }
}
