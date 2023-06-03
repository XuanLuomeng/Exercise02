package week6.day2;

/**
 * @author LuoXuanwei
 * @date 2023/6/3 23:44
 */
public class FlowShop {
    //作业数
    static int n;
    //机器1完成处理时间
    static int f1;
    //完成时间和
    static int f;
    //当前最优解
    static int bestf;
    //各作业所需的处理时间
    static int[][] m;
    //当前作业调度
    static int[] x;
    //当前最优作业调度
    static int[] bestx;
    //机器2完成处理时间
    static int[] f2;

    private static void backtrack(int i) {
        if (i > n) {
            for (int j = 1; j <= n; j++) {
                bestx[j] = x[j];
            }
            bestf = f;
        } else {
            for (int j = i; j <= n; j++) {
                f1 += m[x[j]][0];
                f2[i] = ((f2[i - 1] > f1) ? f2[i - 1] : f1) + m[x[j]][1];
                f += f2[i];
                if (f < bestf) {
                    swap(x, i, j);
                    backtrack(i + 1);
                    swap(x, i, j);
                }
                f1 -= m[x[j]][0];
                f -= f2[i];
            }
        }
    }

    static void swap(int[] x, int i, int j) {
        int ss;
        ss = x[j];
        x[j] = x[i];
        x[i] = ss;
    }

    public static void main(String[] args) {
        n = 5;
        bestf = Integer.MAX_VALUE;
        f1 = 0;
        f = 0;
        m = new int[][]{{0, 0}, {3, 5}, {6, 1}, {5, 2}, {4, 4}, {3, 2}};
        x = new int[]{0, 1, 2, 3, 4, 5};
        bestx = new int[]{0, 1, 2, 3, 4, 5};
        f2 = new int[6];

        backtrack(1);
        System.out.println("当前最优解:" + bestf);
        System.out.println("当前最优作业调度");
        for (int i = 1; i <= n; i++) {
            System.out.print(bestx[i] + "\t");
        }
    }

}
