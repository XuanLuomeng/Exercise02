package week8.day7;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 18:51
 */
public class NQueen {
    static int n;
    static int[] x;
    static long sum;

    public static void main(String[] args) {
        System.out.println("可行性方案:" + nQueen(4));
    }

    private static long nQueen(int nn) {
        n = nn;
        x = new int[n + 1];
        sum = 0;
        for (int i = 0; i <= n; i++) {
            x[i] = 0;
        }
        backTrack(1);
        return sum;
    }

    private static boolean place(int k) {
        for (int i = 1; i < k; i++) {
            if (Math.abs(x[k] - x[i]) == Math.abs(k - i) || x[i] == x[k]) {
                return false;
            }
        }
        return true;
    }

    private static void backTrack(int t) {
        if (t > n) {
            System.out.print("第" + (++sum) + "个可行性方案解为:");
            for (int i = 1; i <= n; i++) {
                System.out.print(x[i] + "\t");
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
