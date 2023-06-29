package week8.day2;

/**
 * m着色问题
 *
 * @author LuoXuanwei
 * @date 2023/6/18 18:33
 */
public class MColoring {
    /**
     * 图的顶点数
     */
    static int n;
    /**
     * 可用颜色数
     */
    static int m;
    /**
     * 图的邻接矩阵
     */
    static boolean[][] a;
    /**
     * 当前解
     */
    static int[] x;
    /**
     * 当钱已找到的可行方案数
     */
    static long sum;

    public static void main(String[] args) {
        a = new boolean[6][6];
        a[1][2] = a[2][1] = true;
        a[1][3] = a[3][1] = true;
        a[2][3] = a[3][2] = true;
        a[2][4] = a[4][2] = true;
        a[2][5] = a[5][2] = true;
        a[3][5] = a[5][3] = true;
        a[4][5] = a[5][4] = true;
        mColoring(3, 5);
        System.out.println("可行方案个数为： " + sum);
    }

    /**
     * 初始化及返回可行解个数
     *
     * @return 可行解个数
     */
    public static long mColoring(int mm, int nn) {
        m = mm;
        n = nn;
        sum = 0;
        x = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            x[i] = 0;
        }
        backTrack(1);
        return sum;
    }

    /**
     * 可行性约束
     *
     * @param k
     * @return 是否可行
     */
    public static boolean place(int k) {
        for (int j = 1; j < k; j++) {
            if (a[k][j] && x[j] == x[k]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 回溯搜索
     *
     * @param t
     */
    public static void backTrack(int t) {
        if (t > n) {
            // 已经找到一种可行解
            System.out.print("第" + (++sum) + "种可行解为： ");
            for (int k = 1; k <= n; k++) {
                System.out.print(x[k] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= m; i++) {
                x[t] = i;
                if (place(t)) {
                    backTrack(t + 1);
                }
                x[t] = 0;
            }
        }
    }
}
