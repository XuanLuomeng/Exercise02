package week8.day1;

/**
 * n皇后问题
 *
 * @author LuoXuanwei
 * @date 2023/6/18 17:33
 */
public class NQueen {

    /**
     * 皇后个数
     */
    static int n;
    /**
     * 当前解
     */
    static int[] x;
    /**
     * 当钱已找到的可行方案数
     */
    static long sum;

    public static void main(String[] args) {
        nQueen(4);
        System.out.println("可行方案个数为： " + sum);
    }

    /**
     * 初始化及返回可行解个数
     *
     * @return 可行解个数
     */
    public static long nQueen(int nn) {
        n = nn;
        sum = 0;
        x = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // 初始化
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
            // 对应公式 |i - k| = |j - l| && 列号不能相同
            if ((Math.abs(k - j) == Math.abs(x[j] - x[k])) || x[j] == x[k]) {
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
            for (int i = 1; i <= n; i++) {
                x[t] = i;
                if (place(t)) {
                    backTrack(t + 1);
                }
            }
        }
    }
}
