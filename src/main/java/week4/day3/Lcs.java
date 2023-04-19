package week4.day3;

public class Lcs {
    public static void main(String[] args) {
        //第0项设为0以此做到规定下标从1开始
        String[] string1 = {"0", "A", "C", "T", "C", "C", "T", "A", "G"};
        String[] string2 = {"0", "C", "A", "T", "T", "C", "A", "G", "C"};
        //建立最优解数组
        int[][] b = new int[string1.length][string2.length];
        int length = lcsLength(string1, string2, b);
        //输出最优值
        System.out.println("最优解:" + length);
        System.out.println();
        //输出最优解数组
        for (int i = 1; i < b.length; i++) {
            for (int j = 1; j < b[i].length; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("最优解：");
        //调用最优解方法
        lcs(string1.length - 1, string2.length - 1, string1, b);
    }

    public static int lcsLength(String[] x, String[] y, int[][] b) {
        //获取两个字符串长度
        int m = x.length;
        int n = y.length;
        //建立最优值数组
        int[][] c = new int[m][n];
        //将数组第一列和第一行置零，方便后续计算以及防止空指针异常
        for (int i = 0; i < m; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            c[0][i] = 0;
        }
        /**
         * 规则：
         * 1、最优值
         * （1）x第i项与y第j项相同，则对应数组位置赋值为1
         * （2）x第i项与y第j项不相同，则取数组min{c[i-1][j],c[i][j-1]}
         * 2、最优解
         * （1）x第i项与y第j项相同，则对应数组位置赋值为1
         * （2）x第i项与y第j项不相同
         *      1）c[i - 1][j] 大于等于 c[i][j - 1]则b[i][j]赋值为2
         *      2）c[i - 1][j] 小于 c[i][j - 1]则b[i][j]赋值为3
         */
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
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
        //返回c数组最右下角的值（为数组当中的最大值）
        return c[m - 1][n - 1];
    }

    /**
     * 利用动态规划，排除无关数组内容，递归分析最优解数组获取并输出最长公共子序列
     * @param i
     * @param j
     * @param x
     * @param b
     */
    public static void lcs(int i, int j, String[] x, int[][] b) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            lcs(i - 1, j - 1, x, b);
            System.out.print(x[i] + "\t");
        } else if (b[i][j] == 2) {
            lcs(i - 1, j, x, b);
        } else {
            lcs(i, j - 1, x, b);
        }
    }
}
