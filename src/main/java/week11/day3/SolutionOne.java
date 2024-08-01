package week11.day3;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/1 20:36
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 */
public class SolutionOne {

    public int maxProfit(int[] prices) {
        //动态规划的二维数组解题不是最优解
//        int[][] earnings = new int[prices.length][2];
//
//        //第i天，拥有/不拥有股票的最大利润是(j为0表示不拥有股票。1表示拥有股票)
//        earnings[0][0] = 0;
//        earnings[0][1] = -prices[0];
//
//        for (int i = 1; i < earnings.length; i++) {
//            //每天判断不拥有股票（出售股票），是出售股票利润最大还是保持拥有股票利润最大
//            earnings[i][0] = Math.max(earnings[i - 1][0], earnings[i - 1][1] + prices[i]);
//            //每天判断拥有股票（购入股票），是购入股票利润最大还是保持不拥有股票利润最大
//            earnings[i][1] = Math.max(earnings[i - 1][1], earnings[i - 1][0] - prices[i]);
//        }
//        return earnings[earnings.length - 1][0];
        //利用动态规划的一维数组为最优解
        int earnings = 0;
        int profit = -prices[0];

        for (int price : prices) {
            earnings = Math.max(earnings, profit + price);
            profit = Math.max(profit, earnings - price);
        }

        return earnings;
    }
}
