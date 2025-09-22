package week15.day3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 两数之和
 * @date 2025/9/22 19:25
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum1(nums, target);
        System.out.println(result);
    }

    // 优化解法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 边遍历边解题，边放入map边判断
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    // 暴力解法
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
