package week13.day2;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/16 20:01
 * <p>
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subs = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int val = c - '0' - 1;
                    rows[i][val]++;
                    cols[j][val]++;
                    subs[i / 3][j / 3][val]++;
                    if (rows[i][val] > 1 || cols[j][val] > 1 || subs[i / 3][j / 3][val] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
