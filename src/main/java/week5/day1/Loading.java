package week5.day1;

public class Loading {
    //第一艘船的重量
    public static int c;
    //货箱重量数组
    public static int[] w;
    //货箱数量
    public static int n;
    //剩余货箱的重量
    public static int r;
    //当前装载的重量
    public static int cw;
    //目前最优装载的重量
    public static int bestw;
    //当前解，记录从根到当前结点的路径
    public static int[] x;
    //记录当前最优解
    public static int[] bestx;

    /**
     * 若当前节点右子树不可能包含当前最优解更好的解时，就不再移动到右子树上。
     * 设bestw为当前最优解，Z为解空间树的第i层的一个节点为剩余货箱的重量；
     * 当cw+r<=bestw时，就没有必要搜索Z的右子树：
     * 当前载重量cw+剩余集装箱的重量r=当前最优载重量bestw
     */
    public static void main(String[] args) {
        int[] ww = {0, 5, 2, 1, 3};
        int c1 = 10;
        int c2 = 12;
        int n = ww.length - 1;

        MaxLoading(ww, c1);
        //保存第二艘船的可能要装载的重量
        int weight2 = 0;
        for (int i = 1; i <= n; i++) {
            //bestx[i]的值只能为1或0
            weight2 += ww[i] * (1 - bestx[i]);
        }
        if (weight2 > c2) {
            System.out.println("无解");
        } else {
            System.out.println("c1最终实际装载货物重量:" + bestw);
            System.out.println("c2最终实际装载货物重量:" + weight2);
            //第一艘船的装载状况
            for (int i = 1; i <= n; i++) {
                if (bestx[i] == 1) {
                    System.out.println("第" + i + "货物装入c1");
                }
            }
            //第二艘船的装载状况
            for (int i = 1; i <= n; i++) {
                if (bestx[i] == 0) {
                    System.out.println("第" + i + "货物装入c2");
                }
            }
        }
    }

    public static int MaxLoading(int[] ww, int cc) {
        //初始化数据成员，数组下标从1开始
        n = ww.length - 1;
        w = ww;
        c = cc;
        cw = 0;
        bestw = 0;
        x = new int[n + 1];
        bestx = new int[n + 1];

        //初始化r，即剩余最大重量
        for (int i = 1; i <= n; i++) {
            r += w[i];
        }

        //计算最优装载重量
        backtrack(1);
        return bestw;
    }

    private static void backtrack(int t) {
        if (t > n) {
            //到达叶节点
            if (cw > bestw) {
                for (int i = 1; i <= n; i++) {
                    bestx[i] = x[i];
                }
                bestw = cw;
            }
            return;
        }
        r -= w[t];
        if (cw + w[t] <= c) {
            //搜索左子树
            x[t] = 1;
            cw += w[t];
            backtrack(t + 1);
            //回溯
            cw -= w[t];
            if (cw + r > bestw) {
                //搜索右子树
                x[t] = 0;
                backtrack(t + 1);
            }
            //恢复现场
            r += w[t];
        }
    }
}