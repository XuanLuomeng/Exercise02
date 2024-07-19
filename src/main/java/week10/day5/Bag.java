package week10.day5;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/5/23 22:12
 */
public class Bag {

    public static int N = 4;
    public static int W = 5;
    public static int[] v = {0, 2, 4, 5, 6};
    public static int[] w = {0, 1, 2, 3, 4};

    public static void main(String[] args) {
        int[][] f = new int[N + 1][W + 1];

        int i, j;
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= W; j++) {
                f[i][j] = f[i - 1][j];

                if (j >= w[i]) {
                    f[i][j] = max(f[i - 1][j], v[i] + f[i - 1][j - w[i]]);
                }
            }
        }

        for (int k = 0; k <= N; k++) {
            for (int l = 0; l <= W; l++) {
                System.out.print(f[k][l] + "\t");
            }
            System.out.println();
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
