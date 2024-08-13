package week12.day6;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/13 22:31
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        //双指针
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int span = right - left;
        while (span > 0) {
            res = height[left] < height[right]
                    ? Math.max(res, (span) * height[left++])
                    : Math.max(res, (span) * height[right--]);
        }
        return res;
    }
}
