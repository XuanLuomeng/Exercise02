package day08.linkedListPojo;

public class LinkNode<T> {
    T data;
    LinkNode<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(LinkNode<T> next) {
        this.next = next;
    }

    public LinkNode() {
        next = null;
    }

    public LinkNode(T data) {
        this.data = data;
        next = null;
    }

    public LinkNode getNext(){
        return next;
    }
}
