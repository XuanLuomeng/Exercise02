package week7.day3;

/**
 * @author LuoXuanwei
 * @date 2023/6/13 11:08
 */
public class OptimalBinarySearchTree {
    private static int[] a = {2, 3, 1, 1, 1};
    private static int[] b = {3, 3, 1, 1};
    private static int n = 4;
    private static int[][] s = new int[a.length + 1][b.length + 1];
    private static float[][] m = new float[a.length + 1][b.length + 1];
    private static float[][] w = new float[a.length + 1][b.length + 1];

    public static void main(String[] args) {
        optimalBinarySearchTree();
        System.out.println("s:");
        show(s);
        System.out.println("m:");
        show(m);
        System.out.println("w:");
        show(w);
    }

    private static void optimalBinarySearchTree() {
        for (int i = 0; i <= n; i++) {
            w[i + 1][i] = a[i];
            m[i + 1][i] = 0;
        }
        for (int r = 0; r < n; r++) {
            for (int i = 1; i <= n - r; i++) {
                int j = r + i;
                w[i][j] = w[i][j - 1] + a[j] + b[j - 1];
                m[i][j] = m[i][i - 1] + m[i + 1][j];
                s[i][j] = i;
                for (int k = i + 1; k <= j; k++) {
                    float t = m[i][k - 1] + m[k + 1][j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
                m[i][j] += w[i][j];
            }
        }
    }

    public static void show(int[][] s) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void show(float[][] s) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
