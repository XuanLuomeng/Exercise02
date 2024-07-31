package week11.day2;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/31 23:42
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class SolutionOne {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - min;
            if (temp > 0) {
                maxProfit = Math.max(maxProfit, temp);
            } else {
                min = prices[i];
            }
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}
