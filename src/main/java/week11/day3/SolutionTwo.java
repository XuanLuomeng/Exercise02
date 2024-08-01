package week11.day3;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/1 20:56
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class SolutionTwo {
    public boolean canJump(int[] nums) {
        int tem = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > tem) {
                return false;
            }
            tem = Math.max(tem, i + nums[i]);
        }
        return true;
    }
}
