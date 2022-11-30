package week2.day14.linkedList;

/**
 * Initialization and assignment of each object
 *
 * @param <T>
 */
public class LinkNode<T> {
    public T data;
    public LinkNode<T> next;

    public LinkNode() {
        next = null;
    }

    public LinkNode(T d) {
        this.data = d;
        this.next = null;
    }
}
