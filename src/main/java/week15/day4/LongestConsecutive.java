package week15.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 最长连续序列
 * @date 2025/9/23 18:00
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    // 哈希表解法:
    // 用Set存储数组中的元素
    // 遍历数组中的元素
    // 获取当前元素的前一个元素，并判断前一个元素是否是当前元素-1
    // 是则跳过当前元素，否则循环判断是否有当前元素+1的数，直到不存在返回循环次数即最长连续序列长度
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }

                res = Math.max(res, count);
            }
        }
        return res;
    }
}
