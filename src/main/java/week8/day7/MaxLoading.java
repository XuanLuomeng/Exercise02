package week8.day7;

import java.util.PriorityQueue;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 20:24
 */
public class MaxLoading {
    static int n;
    static int[] bestx;
    static int[] w;
    static int[] r;
    static int c;
    static PriorityQueue<HeapNode> heap;

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
        int weight;
        int level;

        public HeapNode(BNode liveNode, int weight, int level) {
            this.liveNode = liveNode;
            this.weight = weight;
            this.level = level;
        }

        @Override
        public int compareTo(Object o) {
            int oWeight = ((HeapNode) o).weight;
            if (weight < oWeight) {
                return -1;
            } else if (weight == oWeight) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    private static void addLiveNode(BNode parent, int weight, int level, boolean leftChild) {
        BNode liveNode = new BNode(parent, leftChild);
        HeapNode heapNode = new HeapNode(liveNode, weight, level);
        heap.add(heapNode);
    }

    private static int maxLoading() {
        BNode e = null;
        int i = 1;
        int ew = 0;
        while (i != n + 1) {
            if (ew + w[i] <= c) {
                addLiveNode(e, ew + w[i] + r[i], i + 1, true);
            }
            addLiveNode(e, ew + r[i], i + 1, false);
            HeapNode heapNode = heap.poll();
            e = heapNode.liveNode;
            i = heapNode.level;
            ew = heapNode.weight - r[i - 1];
        }
        System.out.println("最优解数组为：");
        for (int j = 1; j <= n; j++) {
            bestx[j] = e.leftChild ? 1 : 0;
            System.out.print(bestx[j] + "\t");
            e = e.parent;
        }
        System.out.println();

        return ew;
    }

    public static void main(String[] args) {
        w = new int[]{0, 60, 40, 10, 30, 50};
        n = w.length - 1;
        bestx = new int[n + 1];
        r = new int[n + 1];
        heap = new PriorityQueue<HeapNode>((a, b) -> b.weight - a.weight);
        for (int i = n - 1; i > 0; i--) {
            r[i] = r[i + 1] + w[i + 1];
        }

        System.out.print("集装箱重量分别为：");
        for (int i = 1; i < w.length; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.println();

        c = 120;
        System.out.println("轮船1最大载重量为" + c);

        System.out.println("轮船1的最优载重量为：" + maxLoading());
    }
}