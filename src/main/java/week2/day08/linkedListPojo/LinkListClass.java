package week2.day08.linkedListPojo;

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
        for (int len = list.length - 1; len >= 0; len--) {
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

    public void add(LinkNode node) {
        LinkNode last = getNode(getSize() - 1);
        node.next = last.next;
        last.next = node;
    }

    public void Insert(T t) {
        LinkNode<T> s = new LinkNode<>(t);
        LinkNode<T> p = getNode(getSize() - 1);
        s.next = p.next;
        p.next = s;
    }

    public void delete(int i) {
        if (i == 0) {
            head = head.next;
        } else if (i == getSize() - 1) {
            getNode(i - 1).next = null;
        } else if (i < 0 || i >= getSize()) {
            System.out.println("Number of crossing the line!");
        } else {
            getNode(i - 1).next = getNode(i).next;
        }
    }
}
