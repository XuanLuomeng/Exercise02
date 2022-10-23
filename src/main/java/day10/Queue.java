package day10;

public class Queue<E> {
    final int capticity = 100;
    LinkNode<E> front;
    LinkNode<E> rear;
    private E[] data;

    public Queue() {
        front = null;
        rear = null;
    }

    public boolean empty() {
        return front == null;
    }

    public void push(E e) {
        LinkNode<E> s = new LinkNode<E>(e);
        if (empty()) {
            front = rear = s;
        } else {
            rear.next = s;
            rear = s;
        }
    }

    public E pop() {
        E e;
        if (empty()) {
            throw new IllegalArgumentException("队列空");
        }
        if (front == rear) {
            e = (E) front.data;
            front = rear = null;
        } else {
            e = (E) front.data;
            front = front.next;
        }
        return e;
    }

    public E peek() {
        if (empty()) {
            throw new IllegalArgumentException("队列空");
        }
        E e = (E) front.data;
        return e;
    }
}
