package week12.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/13 23:04
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] sortNums = nums;
        Arrays.sort(sortNums);
        List<List<Integer>> res = new ArrayList<>();
        for (int left = 0; left < sortNums.length - 2; left++) {
            //如果最左边的数大于0，那么以题目要求三数相加不可能为0
            if (sortNums[left] >= 0) {
                break;
            }
            if (left > 0 && sortNums[left] == sortNums[left - 1]) {
                continue;
            }
            int right = sortNums.length - 1;
            int middle = left + 1;
            while (middle < right) {
                int sum = sortNums[left] + sortNums[middle] + sortNums[right];
                if (sum > 0) {
                    while (middle < right && nums[right] == nums[--right]) ;
                } else if (sum < 0) {
                    while (middle < right && nums[middle] == nums[++middle]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(sortNums[left], sortNums[middle], sortNums[right])));
                    while (middle < right && nums[right] == nums[--right]) ;
                    while (middle < right && nums[middle] == nums[++middle]) ;
                }
            }
        }
        return res;
    }
}
