package day08.linkedListPojo;

public class TwoWayLinkListClass<T> {
    TwoWayLinkNode<T> head;

    public TwoWayLinkListClass() {
        head = new TwoWayLinkNode<>();
        head.next = null;
        head.last = null;
    }

    public TwoWayLinkListClass(T[] array) {
        head = new TwoWayLinkNode<>();
        head.next = null;
        head.last = null;
        TwoWayLinkNode<T> node;
        for (int len = array.length - 1; len >= 0; len--) {
            node = new TwoWayLinkNode<T>(array[len]);
            node.next = head.next;
            head.next = node;
            if (node.next != null) {
                node.next.last = node;
            }
        }
    }

    public int getSize() {
        TwoWayLinkNode<T> p = head;
        int cnt = 0;
        while (p.next != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public void Insert(T data) {
        TwoWayLinkNode<T> s = new TwoWayLinkNode<>(data);
        TwoWayLinkNode<T> p = getNode(getSize() - 1);
        s.next = p.next;
        s.last = p;
        p.next = s;
    }

    public void delete(int i) {
        if (i == 0) {
            head = head.next;
            head.next.last = null;
        } else if (i == getSize() - 1) {
            getNode(i - 1).next = null;
        } else if (i < 0 || i >= getSize()) {
            System.out.println("Number of crossing the line!");
        } else {
            TwoWayLinkNode linkNode1 = getNode(i - 1);
            TwoWayLinkNode linkNode2 = getNode(i);
            TwoWayLinkNode linkNode3 = getNode(i + 1);
            linkNode1.next = linkNode2.next;
            linkNode3.last = linkNode2.last;
        }
    }

    public TwoWayLinkNode<T> getNode(int i) {
        TwoWayLinkNode<T> p = head;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }

    public T getElem(int i) {
        int size = getSize();
        if (i < 0 || i >= size) {
            throw new RuntimeException("Position i is not within the valid range");
        } else {
            TwoWayLinkNode<T> elem = getNode(i);
            return elem.data;
        }
    }
}
