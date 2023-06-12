package week7.day2;

/**
 * @author LuoXuanwei
 * @date 2023/6/13 0:01
 */
public class OptimalBinarySearchTree {
    public static float[] a = {2, 3, 1, 1, 1};

    public static float[] b = {3, 3, 1, 1};

    public static int n = a.length - 1;

    public static int[][] s = new int[a.length + 1][b.length + 1];

    public static float[][] m = new float[a.length + 1][b.length + 1];

    public static float[][] w = new float[a.length + 1][b.length + 1];

    public static void main(String[] args) {
        optimalBinarySearchTree(m, w, s, a, b);
        System.out.println("s:");
        show(s);
        System.out.println("m:");
        show(m);
        System.out.println("w:");
        show(w);
    }

    public static void optimalBinarySearchTree(float[][] m, float[][] w, int[][] s, float[] a, float[] b) {
        for (int i = 0; i <= n; i++) {
            w[i + 1][i] = a[i];
            m[i + 1][i] = 0;
        }
        for (int r = 0; r < n; r++) {
            for (int i = 1; i <= n - r; i++) {
                int j = i + r;
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
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void show(float[][] s) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}
