package week10.day7;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/29 19:50
 * <p>
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 */
public class SolutionOne {

    private static final String[] operations = {"5","2","C","D","+"};

    public static void main(String[] args) {
        int res = calPoints(operations);
        System.out.println(res);
    }

    public static int calPoints(String[] operations) {
        int x = 0;
        int len = operations.length;
        int sum = 0;
        int[] opr = new int[len];
        for(String ope : operations){
            if (ope.equals("+")) {
                opr[x] = opr[x - 2] + opr[x - 1];
            } else if (ope.equals("D")) {
                opr[x] = opr[x - 1] * 2;
            } else if (ope.equals("C")) {
                sum -= opr[x-1];
                x--;
                continue;
            } else {
                opr[x] = Integer.parseInt(ope);
            }
            sum += opr[x];
        }
        return sum;
    }
}
