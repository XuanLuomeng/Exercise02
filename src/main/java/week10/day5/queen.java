package week10.day5;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/5/23 18:21
 */
public class queen {

    public static int N = 4;

    public static int[] q = new int[N + 1];

    public static int answer = 0;

    public static void main(String[] args) {
        queen(1);
    }

    public static boolean check(int n) {
        for (int i = 1; i < n; i++) {
            if (q[i] == q[n] || Math.abs(q[i] - q[n]) == Math.abs(i - n)) {
                return false;
            }
        }
        return true;
    }

    public static void queen(int i) {
        int j;
        for (j = 1; j <= N; j++) {
            q[i] = j;
            if (check(i)) {
                if (i == N) {
                    answer++;
                    System.out.println("方案:" + answer);
                    for (int k = 1; k <= N; k++) {
                        System.out.print(q[k]);
                    }
                    System.out.println();
                } else {
                    queen(i + 1);
                }
            }
        }
    }
}
