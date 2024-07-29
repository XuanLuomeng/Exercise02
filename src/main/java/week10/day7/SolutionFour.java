package week10.day7;

import java.util.Arrays;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/29 22:47
 * <p>
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 * <p>
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * <p>
 * 返回可能的 最小差值 。
 */
public class SolutionFour {

    private static final int[] nums = {9,4,1,7};

    public static void main(String[] args) {
        int res = minimumDifference(nums, 2);
        System.out.println(res);
    }

    public static int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        int n = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - k + 1; i++) {
            n = Math.min(n, nums[i + k - 1] - nums[i]);
        }
        return n;
    }
}
