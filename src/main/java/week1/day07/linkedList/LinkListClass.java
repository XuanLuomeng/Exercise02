package week1.day07.linkedList;

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

    public void find(String str) {
        LinkNode<T> node = head;
        int side = 0;
        while (node.next != null) {
            if (node.next.data.toString().equals(str)) {
                System.out.println("第" + side + "个节点的内容与" + str + "相同");
            }
            node = node.next;
            side++;
        }
    }

    public void nextCopy(T data) {
        for (int side = 0; side < size(); side++) {
            if (getElem(side).toString().equals(data.toString())) {
                LinkNode<T> newNode = new LinkNode<>(data);
                LinkNode<T> p = getNode(side);
                newNode.next = p.next;
                p.next = newNode;
                side++;
            }
        }
    }

    public void lastCopy(T data) {
        for (int side = 0; side < size(); side++) {
            if (getElem(side).toString().equals(data.toString())) {
                LinkNode<T> newNode = new LinkNode<>(data);
                LinkNode<T> p = getNode(side - 1);
                newNode.next = p.next;
                p.next = newNode;
                side++;
            }
        }
    }

    public void delete(int i) {
        if (i == 0) {
            head = head.next;
        } else if (i == size() - 1) {
            getNode(i - 1).next = null;
        } else if (i < 0 || i >= size()) {
            System.out.println("Number of crossing the line!");
        } else {
            getNode(i - 1).next = getNode(i).next;
        }
    }

    public void nextDelete(int i) {
        if (i - 1 == 0) {
            head = head.next;
        } else if (i == size()) {
            getNode(i - 2).next = null;
        } else if (i - 1 < 0 || i - 1 >= size()) {
            System.out.println("No precursor node or number is not of bounds at this location!");
        } else {
            getNode(i - 2).next = getNode(i - 1).next;
        }
    }

    public void lastDelete(int i) {
        if (i + 1 == 0) {
            head = head.next;
        } else if (i == size() - 2) {
            getNode(i).next = null;
        } else if (i + 1 < 0 || i + 1 >= size()) {
            System.out.println("No rear-drive node or number is not of bounds at this location!");
        } else {
            getNode(i).next = getNode(i + 1).next;
        }
    }

    public void Insert(int i,T t){
        if(i<0||i>size()){
            System.out.println("位置i不在有效范围内");
        }else {
            LinkNode<T> s = new LinkNode<>(t);
            LinkNode<T> p = getNode(i-1);
            s.next = p.next;
            p.next = s;
        }
    }
}
