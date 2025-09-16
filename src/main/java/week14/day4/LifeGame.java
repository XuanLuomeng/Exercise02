package week14.day4;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 生命游戏
 * @date 2025/9/16 21:32
 * <p>
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 1、如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 2、如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 3、如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 4、如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是 同时 发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * <p>
 * 给定当前 board 的状态，更新 board 到下一个状态。
 * <p>
 * 注意 你不需要返回任何东西。
 *
 * 思路一：
 * 使用新的二维数组，通过遍历题目所给数组的元素周围细胞状态，并更新当前数组，最后将数组赋予题目的数组。
 *
 * 思路二(原地算法，不利用其他数组)：
 * 我们首先可以确认的是，没有变化的细胞到最后都不需要进行任何操作。
 * 需要变化的细胞，直接将 0/1 改为 1/0 的话会影响后续细胞状态的计算。
 * 可以利用伪状态，即 2 表示细胞初始态为 活细胞，终止态为 死细胞；相反 -1 表示细胞初始态为 死细胞，终止态为 活细胞。
 * 若判断周围的细胞存在一个伪活细胞(x>=1)，则进行计数。
 * 最终将伪状态细胞改为 0/1。
 */
public class LifeGame {

    private static int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
    };;

    public static void main(String[] args) {
        gameOfLife(board);
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 遍历每个元素周围的细胞，统计细胞数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                // 通过条件运算符避免数组越界
                for (int k = ((i - 1) < 0 ? 0 : i - 1); k <= ((i + 1) == m ? i : i + 1); k++) {
                    for (int l = ((j - 1) < 0 ? 0 : j - 1); l <= ((j + 1) == n ? j : j + 1); l++) {
                        // 跳过元素自身
                        if (k == i && l == j) {
                            continue;
                        }

                        // 统计活着的细胞数(大于1表示该细胞 初始态 为 活细胞)
                        if (board[k][l] >= 1) {
                            count++;
                        }
                    }
                }
                // 判断当前细胞状态，并更新伪状态(状态没有变化的细胞不进行更新)
                if (board[i][j] == 1) {
                    // 活 -> 死
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    // 死 -> 活
                    if (count == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }

        // 更新细胞为最终真实状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
