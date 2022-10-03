package day08.linkedListPojo;

public class TwoWayLinkNode<T> {
    T data;
    TwoWayLinkNode<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TwoWayLinkNode<T> getNext() {
        return next;
    }

    public void setNext(TwoWayLinkNode<T> next) {
        this.next = next;
    }

    public TwoWayLinkNode<T> getLast() {
        return last;
    }

    public void setLast(TwoWayLinkNode<T> last) {
        this.last = last;
    }

    TwoWayLinkNode<T> last;

    public TwoWayLinkNode() {
        next = null;
        last = null;
    }

    public TwoWayLinkNode(T data){
        this.data = data;
        next = null;
        last = null;
    }
}
