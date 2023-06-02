package week6.day1;

import java.util.PriorityQueue;

/**
 * @author LuoXuanwei
 * @date 2023/6/2 10:30
 */
public class Loading {
    //类成员变量
    static int n;               //集装箱数量-1
    static int[] best;          //当前最优解，best[i]表示第i+1个集装箱装载到第best[i]+1艘轮船时最优
    static int[] weight;
    static int[] shipContain;
    static PriorityQueue<HeapNode> heap;    //活结点队列
    static int[] remainArr;

    private static class QNode {
        QNode parent;
        boolean leftChild;

        public QNode(QNode parent, boolean leftChild) {
            this.parent = parent;
            this.leftChild = leftChild;
        }
    }

    private static class HeapNode implements Comparable {
        QNode liveNode;     //活结点
        int uweight;        //活结点优先级
        int level;          //活结点在子集树中所处的层序号

        public HeapNode(QNode node, int up, int lev) {
            liveNode = node;
            uweight = up;
            level = lev;
        }

        @Override
        public int compareTo(Object o) {
            int oUW = ((HeapNode) o).uweight;
            if (uweight < oUW) {
                return -1;
            } else if (uweight == oUW) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public boolean equals(Object obj) {
            return uweight == ((HeapNode) obj).uweight;
        }
    }

    public static int maxLoading(int[] w, int c, int[] best) {
        QNode e = null;             //当前扩展节点
        int currLevel = 0;          //当前扩展节点所处的层序号
        int extendWeight = 0;       //扩展节点所对应的载重量

        //搜索子集空间树
        while (currLevel != n + 1) {
            int wt = extendWeight + w[currLevel];
            if (wt <= c) {
                //左儿子节点为可行节点
                addLiveNode(wt + remainArr[currLevel], currLevel + 1, e, true);
            }
            //检查右儿子节点
            addLiveNode(extendWeight + remainArr[currLevel], currLevel + 1, e, false);

            //取下一扩展节点
            HeapNode node = heap.poll();
            currLevel = node.level;
            e = node.liveNode;
            extendWeight = node.uweight - remainArr[currLevel - 1];
        }
        //构造当前最优解
        System.out.println("最优解数组为：");
        for (int i = 0; i <= n; i++) {
            best[i] = (e.leftChild) ? 1 : 0;
            if (i != n) {
                System.out.print(best[i] + "\t");
            } else {
                System.out.println(best[i]);
            }
            e = e.parent;
        }
        return extendWeight;
    }

    private static void addLiveNode(int up, int lev, QNode par, boolean lChild) {
        QNode b = new QNode(par, lChild);
        HeapNode node = new HeapNode(b, up, lev);
        heap.add(node);
    }

    public static void main(String[] args) {
        weight = new int[]{60, 40, 10, 30, 50};     //每个集装箱重量（从下标1开始）
        shipContain = new int[]{120, 80};           //两艘轮船的载重量分别为c1,c2
        n = weight.length - 1;
        heap = new PriorityQueue<HeapNode>((a, b) -> b.uweight - a.uweight);
        best = new int[n + 1];
        //定义剩余重量数组
        remainArr = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            remainArr[i] = remainArr[i + 1] + weight[i + 1];
        }

        System.out.println("集装箱重量分别为：");
        for (int i = 0; i < weight.length; i++) {
            if (i != weight.length - 1) {
                System.out.print(weight[i] + "\t");
            } else {
                System.out.println(weight[i]);
            }
        }
        System.out.println();

        int sum = 0;
        for (int w : weight) {
            sum += w;
        }
        int bestResult = maxLoading(weight, shipContain[0], best);
        System.out.println("轮船1/轮船2的最优装载重量为：" + bestResult + "/" + (sum - bestResult));
    }

}
