package day10;

public class Stack<E> {
    StackNode<E> head;

    public Stack() {
        head = new StackNode<E>();
        head.next = null;
    }

    public boolean empty() {
        return head.next == null;
    }

    public void push(E e) {
        StackNode<E> s = new StackNode<E>(e);
        s.next = head.next;
        head.next = s;
    }

    //first in last out
    public E pop() {
        if (empty()) {
            throw new IllegalArgumentException("栈空");
        }
        E e = (E) head.next.data;
        head = head.next;
        return e;
    }

    public E peek() {
        if (empty()) {
            throw new IllegalArgumentException("队列空");
        }
        return (E) head.next.data;
    }
}
