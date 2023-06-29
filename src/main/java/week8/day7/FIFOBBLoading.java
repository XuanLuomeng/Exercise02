package week8.day7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 19:50
 */
public class FIFOBBLoading {
    static int n;
    static int bestw;
    static Queue<QNode> queue = new LinkedList();
    static QNode bestE;
    static int[] bestx;
    static int c;
    static int[] w;

    private static class QNode {
        QNode parent;
        boolean leftChild;
        int weight;

        public QNode(QNode parent, boolean leftChild, int weight) {
            this.parent = parent;
            this.leftChild = leftChild;
            this.weight = weight;
        }
    }

    private static void maxLoading() {
        bestw = 0;
        QNode A = new QNode(null, true, 0);
        QNode e = A;
        bestE = A;
        int i = 1;
        int ew = 0;
        int r = 0;
        for (int j = 2; j <= n; j++) {
            r += w[j];
        }
        queue.add(null);
        while (true) {
            int wt = ew + w[i];
            if (wt <= c) {
                if (wt > bestw) {
                    bestw = wt;
                }
                enQueue(wt, i, e, true);
            }
            if (ew + r >= bestw) {
                enQueue(ew, i, e, false);
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
        for (int j = n - 1; j > 0; j--) {
            bestx[j] = bestE.leftChild ? 1 : 0;
            bestE = bestE.parent;
        }
    }

    private static void enQueue(int weight, int level, QNode parent, boolean leftChild) {
        if (level == n) {
            if (weight == bestw) {
                bestE = parent;
                bestx[n] = bestE.leftChild ? 1 : 0;
            }
            return;
        }
        QNode b = new QNode(parent, leftChild, weight);
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
