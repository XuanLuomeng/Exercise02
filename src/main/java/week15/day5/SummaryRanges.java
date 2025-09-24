package week15.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 汇总区间
 * @date 2025/9/24 13:12
 * <p>
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        int left = 0;
        int right = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1){
                right++;
            } else {
                res.add(left == right ? nums[left] + "" :nums[left] + "->" + nums[right]);
                left = i;
                right = i;
            }
        }

        res.add(left == right ? nums[left] + "" :nums[left] + "->" + nums[right]);

        return res;
    }
}
