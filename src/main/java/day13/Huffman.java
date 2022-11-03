package day13;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffman {
    final int MAX = 1000;
    Integer[] weight;
    String str;
    int n;
    Node[] huffmanTree;
    String[] huffmanCode;

    public Huffman() {
        huffmanTree = new Node[MAX];
        huffmanCode = new String[MAX];
        weight = new Integer[MAX];
    }

    public void setData(int n, Integer[] weight, String str) {
        this.n = n;
        for (int size = 0; size < n; size++) {
            this.weight[size] = weight[size];
        }
        this.str = str;
    }

    public void createHuffmanTree() {
        Comparator<Node> priComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int) (o1.getWeight() - o2.getWeight());
            }
        };
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(MAX, priComparator);
        for (int size = 0; size < n; size++) {
            huffmanTree[size] = new Node();
            huffmanTree[size].parent = null;
            huffmanTree[size].date = str.substring(size, size + 1);
            huffmanTree[size].weight = weight[size];
            priorityQueue.offer(huffmanTree[size]);
        }
        for (int size = n; size < (2 * n - 1); size++) {
            Node n1 = priorityQueue.poll();
            Node n2 = priorityQueue.poll();
            huffmanTree[size] = new Node();
            n1.parent = huffmanTree[size];
            n2.parent = huffmanTree[size];
            huffmanTree[size].weight = n1.weight + n2.weight;
            huffmanTree[size].left = n1;
            n1.flag = true;
            huffmanTree[size].right = n2;
            n2.flag = false;
            priorityQueue.offer(huffmanTree[size]);
        }
    }

    private String reverse(String s) {
        String str = "";
        for (int size = s.length() - 1; size >= 0; size--) {
            str += s.charAt(size);
        }
        return str;
    }

    public void createHuffmanCode() {
        for (int size = 0; size < n; size++) {
            huffmanCode[size] = "";
            Node p = huffmanTree[size];
            while (p.parent != null) {
                if (p.flag) {
                    huffmanCode[size] += '0';
                } else {
                    huffmanCode[size] += '1';
                }
                p = p.parent;
            }
            System.out.println("huffmanCode:" + huffmanCode[size]);
            huffmanCode[size] = reverse(huffmanCode[size]);
        }
    }

    public void DispHuffman() {
        for (int size = 0; size < n; size++) {
            System.out.println(huffmanTree[size].date + " " + huffmanCode[size]);
        }
    }
}
