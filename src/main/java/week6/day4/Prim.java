package week6.day4;

/**
 * @author LuoXuanwei
 * @date 2023/6/6 23:41
 */
public class Prim {
    static int n = 6;
    static float[] lowcost = new float[n];
    static int[] closest = new int[n];
    static boolean[] s = new boolean[n];
    static float[][] c = new float[n][n];

    public static void main(String[] args) {
        //默认没有连通的点均为无限长
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = Float.MAX_VALUE;
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

    public static void prim() {
        //初始化第一个点的所有相关信息
        s[0] = true;
        for (int i = 1; i < n; i++) {
            lowcost[i] = c[0][i];
            closest[i] = 0;
            s[i] = false;
        }
        //总共要选出n-1个点（即循环次数为n-1，i在后续操作仅作为循环层数，无其他作用）
        for (int i = 0; i < n - 1; i++) {
            //寻找已选点集合s到所有未选点的最小距离以及点序号
            float min = Float.MAX_VALUE;
            int j = 0;
            for (int k = 1; k < n; k++) {
                if ((lowcost[k] < min) && (!s[k])) {
                    min = lowcost[k];
                    j = k;
                }
            }
            //输出点序号并将该点序号加入已选点集合s
            System.out.println(j + "\t" + closest[j] + "\t" + "距离为:" + lowcost[j]);
            s[j] = true;
            //修改已选点集合s到剩余为选点的最小距离
            for (int k = 1; k < n; k++) {
                if ((c[j][k] < lowcost[k]) && (!s[k])) {
                    lowcost[k] = c[j][k];
                    closest[k] = j;
                }
            }
        }
    }

}
