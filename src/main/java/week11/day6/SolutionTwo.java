package week11.day6;

import java.util.Arrays;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/4 17:39
 * <p>
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * 翻译：比较左右两个孩子，评分高于他们其中一个或多个，则糖果也要比他或他们更多。
 * <p>
 * 解题思路：
 * 两个数组，第一个数组顺时针判断第i个孩子比前面孩子评分高则在他基础上糖果+1
 * 第二个数组逆时针判断第i个孩子比后面的孩子评分高则在他基础上糖果+1
 * 最后取两个数组第i个位置的最大值作为第i个孩子的糖果数
 */
public class SolutionTwo {

    public int candy(int[] ratings) {
        int len = ratings.length;
        int count = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        //初始化数组，此方法看起来更高大上
//        Arrays.fill(left, 1);
//        Arrays.fill(right, 1);
        //此方法更快
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        }
        count += left[len - 1];
        for (int i = len - 2; i > 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
            count += Math.max(right[i], left[i]);
        }

        return count;
    }
}
