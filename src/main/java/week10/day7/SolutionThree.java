package week10.day7;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/29 22:37
 * <p>
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。
 * <p>
 * 给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。
 * <p>
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
 * <p>
 * 返回这场比赛中将会成为冠军的队伍。
 */
public class SolutionThree {
    public static void main(String[] args) {

    }

    public static int findChampion(int[][] grid) {
        int winner = 0;
        for (int i = 0; i < grid.length; i++) {
            winner = grid[winner][i] > 0 ? winner : i;
        }
        return winner;
    }
}
