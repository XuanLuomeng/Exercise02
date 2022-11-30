package week1.day06.linkedList;

/**
 * Store linked lists, and two methods of creating tables: head inserting method and tail inserting method
 *
 * @param <T>
 */
public class LinkListClass<T> {
    LinkNode<T> head;

    public LinkListClass() {
        head = new LinkNode<T>();
        head.next = null;
    }

    public void createListTop(T[] a) {
        LinkNode<T> s;
        for (int i = 0; i < a.length; i++) {
            s = new LinkNode<T>(a[i]);
            s.next = head.next;
            head.next = s;
        }
    }

    public void createListTail(T[] a) {
        LinkNode<T> s, t;
        t = head;
        for (int i = 0; i < a.length; i++) {
            s = new LinkNode<T>(a[i]);
            t.next = s;
            t = s;
        }
        t.next = null;
    }

    private LinkNode<T> getNode(int i) {
        LinkNode<T> p = head;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }

    public int size() {
        LinkNode<T> p = head;
        int cnt = 0;
        while (p.next != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public T getElem(int i) {
        int len = size();
        if (i < 0 || i > len - 1) {
            throw new RuntimeException("Position i is not within the valid range");
        } else {
            LinkNode<T> p = getNode(i);
            return p.data;
        }
    }
}
