package week2.day10;

public class StackNode <E>{
    E data;
    StackNode<E> next;
    public StackNode()
    {
        next=null;
    }
    public StackNode(E d)
    {
        data=d;
        next=null;
    }
}
