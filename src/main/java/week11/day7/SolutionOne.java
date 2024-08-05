package week11.day7;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/5 23:30
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class SolutionOne {
    public int trap(int[] height) {
        int len = height.length;
        int left = 1;
        int right = len - 2;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;
        for (int i = 1; i < len - 2; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                if (maxLeft > height[left]) {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                if (maxRight > height[right]) {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
