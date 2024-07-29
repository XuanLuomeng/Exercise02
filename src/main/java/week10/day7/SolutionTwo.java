package week10.day7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/29 20:12
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class SolutionTwo {

    private static final int[] nums = {2, 7, 11, 15};
    private static final int target = 9;

    public static void main(String[] args) {
        int[] res = twoSum(nums, target);
        System.out.println(res);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = -1;
        for (int i = 0; i < nums.length; i++) {
            n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
