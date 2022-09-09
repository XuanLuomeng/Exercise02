package day05.listArray;

public class SqListClass<E> {
    final int initcapacity = 10;
    public E[] data;
    public int size;
    private int capacity;

    public SqListClass() {
        data = (E[]) new Object();
        capacity = initcapacity;
        size = 0;
    }
}
