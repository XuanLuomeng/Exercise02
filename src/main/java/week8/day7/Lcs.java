package week8.day7;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 16:40
 */
public class Lcs {
    private static String[] x = {"0", "A", "C", "T", "C", "C", "T", "A", "G"};
    private static String[] y = {"0", "C", "A", "T", "T", "C", "A", "G", "C"};
    private static int[][] b = new int[x.length][y.length];

    public static void main(String[] args) {
        System.out.println(lcsLength());
        lcs(x.length - 1, y.length - 1);
    }

    private static int lcsLength() {
        int m = x.length;
        int n = y.length;
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            c[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (x[i].equals(y[j])) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else {
                    if (c[i - 1][j] >= c[i][j - 1]) {
                        c[i][j] = c[i - 1][j];
                        b[i][j] = 2;
                    } else {
                        c[i][j] = c[i][j - 1];
                        b[i][j] = 3;
                    }
                }
            }
        }
        return c[m - 1][n - 1];
    }

    private static void lcs(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            System.out.print(x[i] + "\t");
            lcs(i - 1, j - 1);
        } else if (b[i][j] == 2) {
            lcs(i - 1, j);
        } else {
            lcs(i, j - 1);
        }
    }
}
