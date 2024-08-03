package week11.day5;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/3 23:57
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class SolutionOne {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        //最好考虑len == 0的情况
        if (len==0){
            return new int[0];
        }
        int[] ans = new int[len];
        int temp = 1;
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            ans[i] *= temp;
        }
        return ans;
    }
}
