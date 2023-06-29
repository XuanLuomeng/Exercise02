package week8.day7;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 17:24
 */
public class MaxSubSeqSum {
    private static int[] list = {10, -1, 9, 20, 0, -3, -42, 20, 31};

    public static void main(String[] args) {
        System.out.println(maxSubSeqSum());
    }

    private static int maxSubSeqSum() {
        int len = list.length;
        int maxSum = 0;
        int nowSum = 0;
        for (int i = 0; i < len; i++) {
            nowSum += list[i];
            if (nowSum < 0) {
                nowSum = 0;
            }
            maxSum = Math.max(nowSum, maxSum);
        }
        return maxSum;
    }
}
