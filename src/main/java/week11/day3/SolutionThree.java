package week11.day3;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/1 21:13
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 解题思路类似于跳跃游戏求是否可以跳跃到终点，
 * 类似贪心思想，需要有“远见”，需要判断第二次跳跃的最远距离
 * 第一次跳跃获得所能跳跃的范围，第二次跳跃获取所能跳跃的最远距离
 * 从跳跃的最远距离的点再次重复上一条规则直至跳跃到终点
 * 当i+nums[i]>=nums.length时则到达终点
 */
public class SolutionThree {
    public int jump(int[] nums) {
//        int start = 0;
        int temp = 0;
//        int end = 1;
        int end = 0;
        int count = 0;
//        while (end < nums.length) {
//            int temp = 0;
//            for (int i = start; i < end; i++) {
//                temp = Math.max(temp, i + nums[i]);
//            }
//            start = end;
//            end = temp + 1;
//            count++;
//        }
        //通过观察可以发现i时从0从头跑到尾的，同时当i到达所谓的一个end的时候，就执行了一次count++，同时刷新了下一次end为最远距离+1
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(temp, i + nums[i]);
            if (i == end) {
                end = temp;
                count++;
            }
        }
        return count;
    }
}
