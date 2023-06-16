package week7.day6;

/**
 * @author LuoXuanwei
 * @date 2023/6/16 23:57
 */
public class MaxSubseqSum {
    private static int[] list = {10, -1, 9, 20, 0, -3, -42, 20, 31};

    public static void main(String[] args) {
        System.out.println(MaxSubseqSum());
    }

    private static int MaxSubseqSum() {
        int length = list.length;
        int maxSum = 0, nowSum = 0;
        for (int i = 0; i < length; i++) {
            nowSum += list[i];
            if (nowSum < 0) {
                nowSum = 0;
            }
            maxSum = Math.max(maxSum, nowSum);
        }
        return maxSum;
    }
}
