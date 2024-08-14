package week12.day7;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/14 22:00
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int res = minSubArrayLen(7,arr);
        System.out.println(res);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int windowSum = 0;
        int len = nums.length;
        while (right < len) {
            //右指针扩大窗口
            windowSum += nums[right];

            while (windowSum >= target) {
                result = Math.min(result, right - left + 1);
                windowSum -= nums[left];
                //左指针缩小窗口
                left++;
            }

            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
