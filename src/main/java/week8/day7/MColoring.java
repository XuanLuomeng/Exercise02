package week8.day7;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 19:13
 */
public class MColoring {
    static int n;
    static int m;
    static int[] x;
    static long sum;
    static boolean[][] a;

    public static void main(String[] args) {
        a = new boolean[6][6];
        a[1][2] = a[2][1] = true;
        a[1][3] = a[3][1] = true;
        a[2][3] = a[3][2] = true;
        a[2][4] = a[4][2] = true;
        a[2][5] = a[5][2] = true;
        a[3][5] = a[5][3] = true;
        a[4][5] = a[5][4] = true;
        System.out.println("可行方案个数为： " + mColoring(3, 5));
    }

    private static long mColoring(int mm, int nn) {
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

    private static boolean place(int j) {
        for (int k = 1; k < j; k++) {
            if (a[j][k] && x[j] == x[k]) {
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
