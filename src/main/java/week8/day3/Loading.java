package week8.day3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LuoXuanwei
 * @date 2023/6/19 15:26
 */
public class Loading {
    static int n;
    static int c;
    static int bestw;
    static int[] w;
    static Queue<QNode> queue;
    static int[] bestx;
    static QNode bestE;

    static class QNode {
        QNode parent;
        int weight;
        boolean leftChild;

        public QNode(QNode parent, int weight, boolean leftChild) {
            this.parent = parent;
            this.weight = weight;
            this.leftChild = leftChild;
        }
    }

    private static void enQueue(QNode parent, int weight, boolean leftChild, int i) {
        if (i == n) {
            if (weight == bestw) {
                bestE = parent;
                bestx[n] = bestE.leftChild ? 1 : 0;
            }
            return;
        }
        QNode node = new QNode(parent, weight, leftChild);
        queue.add(node);
    }

    private static void maxLoading() {
        int i = 1;
        int r = 0;
        int ew = 0;
        QNode A = new QNode(null, 0, true);
        bestE = A;
        QNode e = A;
        queue = new LinkedList<>();
        queue.add(null);
        for (int j = 2; j <= n; j++) {
            r += w[i];
        }
        while (true) {
            int wt = ew + w[i];
            if (wt <= c) {
                if (wt > bestw) {
                    bestw = wt;
                }
                enQueue(e, wt, true, i);
            }
            if (ew + r >= bestw) {
                enQueue(e, ew, false, i);
            }
            e = queue.poll();
            if (e == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                e = queue.remove();
                i++;
                r -= w[i];
            }
            ew = e.weight;
        }
        for (int j = n - 1; j >= 0; j--) {
            bestx[j] = bestE.leftChild ? 1 : 0;
            System.out.print(bestx[j] + "\t");
            bestE = bestE.parent;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        w = new int[]{0, 60, 30, 10, 40, 50};
        n = w.length - 1;
        c = 120;
        bestx = new int[n + 1];

        System.out.print("集装箱重量分别为：");
        for (int i = 1; i < w.length; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.println();

        System.out.println("轮船1最大载重量为" + c);

        maxLoading();
        System.out.println("轮船1的最优载重量为：" + bestw);
    }
}
