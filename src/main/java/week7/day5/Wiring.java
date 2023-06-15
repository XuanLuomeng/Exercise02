package week7.day5;

/**
 * @author LuoXuanwei
 * @date 2023/6/15 19:49
 */
public class Wiring {
    //下标为0用于辅助位
    private static int[] pii = {0, 6, 8, 12, 2, 1, 4, 5, 3, 11, 7, 10, 9, 13};
    private static int[] p = new int[pii.length];
    private static int[][] size = new int[pii.length][pii.length];
    private static int n = pii.length - 1;

    public static void main(String[] args) {
        mnet();
        for (int i = 0; i < size.length; i++) {
            for (int j = 0; j < size.length; j++) {
                System.out.print(size[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(traceBack());
        for (int i = 0; i < p.length; i++) {
            if (p[i] != 0) {
                System.out.print(p[i] + "\t");
            }
        }
    }

    private static void mnet() {
//        for (int i = 1; i < pii[1]; i++) {
//            size[1][i] = 0;
//        }
//        for (int i = pii[1]; i <= n; i++) {
//            size[1][i] = 1;
//        }
        //此代码不适用于有0号电线
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < pii[i]; j++) {
                size[i][j] = size[i - 1][j];
            }
            for (int j = pii[i]; j <= n; j++) {
                size[i][j] = Math.max(size[i - 1][j], size[i - 1][pii[i] - 1] + 1);
            }
        }
    }

    private static int traceBack() {
        int j = n;
        int k = 0;
        //数组下标0为辅助位，不适用于循环判断，需分开使用专属方式进行判断是否加入到数组当中
        for (int i = n; i > 1; i--) {
            if (size[i][j] != size[i - 1][j]) {
                p[k++] = i;
                j = pii[i] - 1;
            }
        }
        if (j >= pii[1]) {
            p[k++] = 1;
        }
        return k;
    }
}
