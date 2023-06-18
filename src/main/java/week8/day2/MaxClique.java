package week8.day2;

/**
 * @author LuoXuanwei
 * @date 2023/6/18 19:05
 */
public class MaxClique {
    /**
     * 图顶点数
     */
    static int n;
    /**
     * 当前最大顶点数
     */
    static int bestn;
    /**
     * 当前顶点数
     */
    static int cn;
    /**
     * 当前解
     */
    static int[] x;
    /**
     * 当前最优解
     */
    static int[] bestx;
    /**
     * 图的邻接矩阵
     */
    static int[][] a;

    public static int maxClique(int[] v) {
        x = new int[n + 1];
        cn = 0;
        bestn = 0;
        bestx = v;
        backtrack(1);
        return bestn;
    }

    public static void backtrack(int t) {
        if (t > n) {
            //到达叶节点
            for (int i = 1; i <= n; i++) {
                bestx[i] = x[i];
            }
            bestn = cn;
            return;
        }
        int ok = 1;
        for (int i = 1; i < t; i++) {
            //检查顶点i与当前团的连接
            if (x[i] == 1 && a[t][i] == 0) {
                ok = 0;
                break;
            }
        }
        if (ok == 1) {
            x[t] = 1;
            cn++;
            backtrack(t + 1);
            cn--;
        }
        if (cn + n - t > bestn) {
            x[t] = 0;
            backtrack(t + 1);
        }
    }

    public static void main(String[] args) {

    }
}
