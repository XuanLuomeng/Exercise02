package week11.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/30 19:04
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class SolutionTwo {
    public int majorityElement(int[] nums) {
        int number = nums[0];
        int count = 0;
        for (int num : nums) {
            if (number == num) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    number = num;
                    count = 0;
                }
            }
        }
        return number;
    }
}
