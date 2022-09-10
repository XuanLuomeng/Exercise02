package day05.listArray;

public class SqListClass<E> {
    final int initcapacity = 10;
    public E[] data;
    public int size;
    private int capacity;

    /**
     *initialization
     */
    public SqListClass() {
        data = (E[]) new Object[initcapacity];
        capacity = initcapacity;
        size = 0;
    }

    /**
     * Get the ith content
     * @param i
     * @return
     */
    public E loc(int i) {
        return data[i];
    }

    /**
     * Find whether the value "content" exists
     * @param content
     * @return
     */
    public boolean find(E content) {
        boolean sign = false;
        for (int length = 0; length < size; length++) {
            if (data[length].toString().equals(content.toString())) {
                sign = true;
            }
        }
        return sign;
    }

    /**
     * Find the place where the content appears for the first time, and return - 1 if it does not exist
     * @param content
     * @return
     */
    public int search(E content) {
        int site = -1;
        for (int length = 0; length < size; length++) {
            if (data[length].toString().equals(content.toString())) {
                site = length;
                break;
            }
        }
        return site;
    }

    /**
     * Start from the "start" to find the place where the content appears for the first time.
     * If it does not exist, return - 1
     * @param content
     * @param start
     * @return
     */
    public int search(E content, int start) {
        int site = -1;
        for (int length = start; length < size; length++) {
            if (data[length].toString().equals(content.toString())) {
                site = length;
                break;
            }
        }
        return site;
    }

    /**
     * Add at the end
     * @param content
     */
    public void append(E content) {
        dilatate();
        data[size] = content;
        size++;
    }

    /**
     *Add content at site
     * @param content
     * @param site
     */
    public void insert(E content, int site) {
        dilatate();
        for (int position = size; position > site; position++) {
            data[position + 1] = data[position];
        }
        data[site] = content;
        size++;
    }

    /**
     * Delete the value of content. If the value does not exist, return false
     * @param content
     * @return
     */
    public boolean delete(E content) {
        boolean sign = false;
        for (int position = 0; position < size; position++) {
            if (data[position].toString().equals(content.toString())) {
                for (int site = position; site < size; site++) {
                    data[site] = data[site + 1];
                }
                size--;
                sign = true;
            }
        }
        return sign;
    }

    /**
     * Before adding content, check whether the array size is insufficient.
     * If it is insufficient, regenerate the array with larger capacity
     */
    public void dilatate() {
        if ((size + 1) == capacity) {
            capacity = capacity + capacity / 2;
            E[] substitute = (E[]) new Object[capacity];
            for (int position = 0; position < size + 1; position++) {
                substitute[position] = data[position];
            }
            data = substitute;
        }
    }
}
