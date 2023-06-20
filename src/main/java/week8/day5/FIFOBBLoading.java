package week8.day5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LuoXuanwei
 * @date 2023/6/18 19:49
 */
public class FIFOBBLoading {

    private static class QNode {
        /**
         * 父节点
         */
        QNode parent;
        /**
         * 左右孩子节点
         */
        boolean leftChild;
        /**
         * 权重
         */
        int weight;

        private QNode(QNode parent, boolean leftChild, int weight) {
            this.parent = parent;
            this.leftChild = leftChild;
            this.weight = weight;
        }
    }

    static int n;
    /**
     * 当前最优装载重量
     */
    static int bestw;
    /**
     * 活结点队列
     */
    static Queue<QNode> queue = new LinkedList();
    static QNode bestE;
    static int[] bestx;
    static int c;
    static int[] w;

    public static void maxLoading() {
        //该算法实施对解空间树的队列式分支限界搜索，返回最优装载重量
        bestw = 0;
        //创建根结点A
        QNode A = new QNode(null, true, 0);
        QNode e = A;
        bestE = A;
        int i = 1;
        int ew = 0;
        int r = 0;
        for (int j = 2; j <= n; j++) {
            r += w[j];
        }
        //当元素的值为空时，表示队列已达到解空间树同一层结点尾部
        queue.add(null);
        //搜索子集空间树
        while (true) {
            //检查左儿子结点
            //左儿子节点的重量
            int wt = ew + w[i];
            if (wt <= c) {
                //可行结点
                if (wt > bestw) {
                    bestw = wt;
                }
                enQueue(wt, i, e, true);
            }
            //检查右儿子结点
            if (ew + r >= bestw) {
                enQueue(ew, i, e, false);
            }
            //取下一扩展结点
            e = queue.poll();
            if (e == null) {
                //同层结点尾部
                if (queue.isEmpty()) {
                    break;
                }
                //同层结点尾部标志
                queue.add(null);
                //下一扩展结点
                e = queue.remove();
                //进入下一层
                i++;
                //剩余集装箱重量
                r -= w[i];
            }
            ew = e.weight;
        }
        //构造当前最优解
        for (int j = n - 1; j > 0; j--) {
            bestx[j] = (bestE.leftChild) ? 1 : 0;
            bestE = bestE.parent;
        }
    }

    private static void enQueue(int wt, int i, QNode parent, boolean leftChild) {
        if (i == n) {
            //可行叶子节点
            if (wt == bestw) {
                //当前最优装载重量
                bestE = parent;
                bestx[n] = (bestE.leftChild) ? 1 : 0;
            }
            return;
        }
        //非叶子节点，将节点加入到活结点队列
        QNode b = new QNode(parent, leftChild, wt);
        queue.add(b);
    }

    public static void main(String[] args) {
        w = new int[]{0, 60, 40, 10, 30, 50};
        n = 5;
        bestx = new int[n + 1];
        c = 120;

        maxLoading();
        System.out.println("最优装载重量:" + bestw);
        for (int i = 1; i <= n; i++) {
            System.out.print(bestx[i] + "\t");
        }
        System.out.println();
    }
}