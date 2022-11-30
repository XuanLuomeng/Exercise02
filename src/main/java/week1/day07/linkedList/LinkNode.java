package week1.day07.linkedList;

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
        data = d;
        next = null;
    }
}
