package week8.day5;

import java.util.PriorityQueue;

/**
 * @author LuoXuanwei
 * @date 2023/6/19 14:18
 */
public class MaxLoading {
    //类数据成员
    static int n;
    static int[] bestx;
    static int[] weight;
    static PriorityQueue<HeapNode> heap;
    static int[] remainArr;

    static class Bnode {
        Bnode parent;
        boolean leftChild;

        Bnode(Bnode parent, boolean leftChild) {
            this.parent = parent;
            this.leftChild = leftChild;
        }
    }

    static class HeapNode implements Comparable {
        Bnode liveNode;
        int weight;         //活结点上界
        int level;          //活结点在子集树中所处的层序号

        HeapNode(Bnode liveNode, int weight, int level) {
            this.liveNode = liveNode;
            this.weight = weight;
            this.level = level;
        }

        @Override
        public int compareTo(Object o) {
            int oWeight = ((HeapNode) o).weight;
            if (weight < oWeight) {
                return -1;
            }
            if (weight == oWeight) {
                return 0;
            }
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            return weight == ((HeapNode) o).weight;
        }
    }

    private static void addLiveNode(Bnode parent, boolean leftChild, int weight, int level) {
        Bnode bnode = new Bnode(parent, leftChild);
        HeapNode node = new HeapNode(bnode, weight, level);
        heap.add(node);
    }

    public static int maxLoading(int[] w, int c, int[] bestx) {
        Bnode e = null;
        int i = 1;
        int ew = 0;
        //搜索子集空间树
        while (i != n + 1) {
            //检查当前扩展结点的左儿子结点
            if (ew + w[i] <= c) {
                //左儿子节点为可行节点
                addLiveNode(e, true, ew + w[i] + remainArr[i], i + 1);
            }
            //检查右儿子节点
            addLiveNode(e, false, ew + remainArr[i], i + 1);
            //取下一扩展结点
            HeapNode node = heap.poll();
            i = node.level;
            e = node.liveNode;
            ew = node.weight - remainArr[i - 1];
        }
        //构造当前最优解
        System.out.println("最优解数组为：");
        for (int j = 1; j <= n; j++) {
            bestx[j] = (e.leftChild) ? 1 : 0;
            System.out.print(bestx[j] + "\t");
            e = e.parent;
        }
        System.out.println();

        return ew;
    }

    public static void main(String[] args) {
        // 每个集装箱重量（从下标1开始）
        weight = new int[]{0, 60, 40, 10, 30, 50};

        n = weight.length - 1;
        heap = new PriorityQueue<HeapNode>((a, b) -> b.weight - a.weight);
        bestx = new int[n + 1];
        // 定义剩余重量数组
        remainArr = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            remainArr[i] = remainArr[i + 1] + weight[i + 1];
        }

        System.out.print("集装箱重量分别为：");
        for (int i = 1; i < weight.length; i++) {
            System.out.print(weight[i] + " ");
        }
        System.out.println();

        int c1 = 120;
        System.out.println("轮船1最大载重量为" + c1);

        System.out.println("轮船1的最优载重量为：" + maxLoading(weight, c1, bestx));
    }
}