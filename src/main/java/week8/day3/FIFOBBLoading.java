package week8.day3;

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

    private static void enQueue(int wt, int i, QNode parent, boolean leftChild) {
        if (i == n) {
            //可行叶子节点
            if (wt == bestw) {
                //当前最优装载重量
                bestE = parent;
                bestx[n] = (leftChild) ? 1 : 0;
            }
            return;
        }
        //非叶子节点，将节点加入到活结点队列
        QNode b = new QNode(parent, leftChild, wt);
        queue.add(b);
    }

    static int n;
    /**
     * 当前最优装载重量
     */
    static int bestw;
    /**
     * 活结点队列
     */
    static Queue<QNode> queue;
    static QNode bestE;
    static int[] bestx;

    public static int maxLoading(int[] w, int c, int[] xx) {
        //该算法实施对解空间树的队列式分支限界搜索，返回最优装载重量
        bestw = 0;
        //创建根结点A
        QNode A = new QNode(null, true, 0);
        //队列用来存放活结点表
        queue = new LinkedList();
        QNode e = A;
        bestE = A;
        bestx = xx;
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
            e = (QNode) queue.remove();
            if (e == null) {
                //同层结点尾部
                if (queue.isEmpty()) {
                    break;
                }
                //同层结点尾部标志
                queue.add(null);
                //下一扩展结点
                e = (QNode) queue.remove();
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
        return bestw;
    }

    public static void main(String[] args) {

    }
}