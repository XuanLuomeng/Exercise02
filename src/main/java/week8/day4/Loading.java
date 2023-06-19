package week8.day4;

import java.util.PriorityQueue;

/**
 * @author LuoXuanwei
 * @date 2023/6/19 14:36
 */
public class Loading {
    static int n;
    static int[] bestx;
    static int[] weight;
    static int c;
    static PriorityQueue<HeapNode> queue;
    static int[] r;

    static class BNode {
        BNode parent;
        boolean leftChild;

        public BNode(BNode parent, boolean leftChild) {
            this.parent = parent;
            this.leftChild = leftChild;
        }
    }

    static class HeapNode implements Comparable {
        BNode liveNode;
        int level;
        int weight;

        public HeapNode(BNode liveNode, int level, int weight) {
            this.liveNode = liveNode;
            this.level = level;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            int oweight = ((HeapNode) o).weight;
            if (weight < oweight) {
                return -1;
            } else if (weight == oweight) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public boolean equals(Object o) {
            return weight == ((HeapNode) o).weight;
        }
    }

    private static void addLiveNode(BNode parent, int level, int weight, boolean leftChild) {
        BNode liveNode = new BNode(parent, leftChild);
        HeapNode heapNode = new HeapNode(liveNode, level, weight);
        queue.add(heapNode);
    }

    private static int maxLoading() {
        int ew = 0;
        int i = 1;
        BNode e = null;
        while (i != n + 1) {
            if (ew + weight[i] <= c) {
                addLiveNode(e, i + 1, ew + weight[i] + r[i], true);
            }
            addLiveNode(e, i + 1, ew + r[i], false);
            HeapNode heapNode = queue.poll();
            e = heapNode.liveNode;
            i = heapNode.level;
            ew = heapNode.weight - r[i - 1];
        }
        System.out.println("当前最优装载重量:");
        for (int j = 1; j <= n; j++) {
            bestx[j] = (e.leftChild) ? 1 : 0;
            System.out.print(bestx[j] + "\t");
            e = e.parent;
        }
        System.out.println();

        return ew;
    }

    public static void main(String[] args) {
        weight = new int[]{0, 60, 40, 10, 30, 50};
        n = weight.length - 1;
        bestx = new int[n + 1];
        queue = new PriorityQueue<>((a, b) -> b.weight - a.weight);
        c = 120;
        r = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            r[i] = r[i + 1] + weight[i + 1];
        }

        System.out.print("集装箱重量分别为：");
        for (int i = 1; i < weight.length; i++) {
            System.out.print(weight[i] + " ");
        }
        System.out.println();

        System.out.println("轮船1最大载重量为" + c);

        System.out.println("轮船1的最优载重量为：" + maxLoading());
    }
}
