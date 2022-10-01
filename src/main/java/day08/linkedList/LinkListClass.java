package day08.linkedList;

public class LinkListClass<T> {
    LinkNode<T> head;

    public LinkListClass() {
        head = new LinkNode<T>();
        head.next = null;
    }

    public LinkListClass(T[] list) {
        head = new LinkNode<T>();
        head.next = null;
        LinkNode<T> node;
        for (int len = 0; len < list.length; len++) {
            node = new LinkNode<T>(list[len]);
            node.next = head.next;
            head.next = node;
        }
    }

    public LinkNode<T> getNode(int i) {
        LinkNode<T> p = head;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }

    public int getSize() {
        LinkNode<T> p = head;
        int cnt = 0;
        while (p.next != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public T getElem(int i) {
        int size = getSize();
        if (i < 0 || i >= size) {
            throw new RuntimeException("Position i is not within the valid range");
        } else {
            LinkNode<T> elem = getNode(i);
            return elem.data;
        }
    }
}
