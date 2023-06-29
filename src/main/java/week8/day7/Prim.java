package week8.day7;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 17:33
 */
public class Prim {
    static int n = 6;                       //点的数量
    static int[] lowCost = new int[n];      //与每个点的最短距离
    static int[] cloSest = new int[n];      //每个点与哪个点相连
    static boolean[] s = new boolean[n];    //每个点是否已选
    static int[][] c = new int[n][n];       //该点与最短距离的点之间的距离

    public static void main(String[] args) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = Integer.MAX_VALUE;
            }
        }
        c[0][1] = c[1][0] = 34;
        c[0][4] = c[4][0] = 12;
        c[1][2] = c[2][1] = 46;
        c[1][5] = c[5][1] = 19;
        c[2][3] = c[3][2] = 17;
        c[2][5] = c[5][2] = 25;
        c[3][4] = c[4][3] = 38;
        c[3][5] = c[5][3] = 25;
        c[4][5] = c[5][4] = 26;
        prim();
    }

    private static void prim() {
        s[0] = true;
        for (int i = 1; i < n; i++) {
            lowCost[i] = c[0][i];
            cloSest[i] = 0;
            s[i] = false;
        }
        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int j = 0;
            for (int k = 1; k < n; k++) {
                if (lowCost[k] < min && !s[k]) {
                    min = lowCost[k];
                    j = k;
                }
            }
            System.out.println(j + "\t" + cloSest[j] + "\t距离为:" + lowCost[j]);
            s[j] = true;
            for (int k = 1; k < n; k++) {
                if (c[j][k] < lowCost[k] && !s[k]) {
                    lowCost[k] = c[j][k];
                    cloSest[k] = j;
                }
            }
        }
    }
}
