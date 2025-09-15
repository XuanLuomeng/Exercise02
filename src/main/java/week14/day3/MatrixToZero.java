package week14.day3;

import java.util.HashSet;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 矩阵置零
 * @date 2025/9/15 20:18
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class MatrixToZero {

    private static int[][] matrix = {{1, 1, 1}, {1, 1, 1}, {1, 1, 0}};

    public static void main(String[] args) {
//        setZeroes(matrix);
        setZeroes1(matrix);

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    // 最优解: 首先将第一行和第一列作为工具，记录是否存在0最后再对其置零，
    // 然后当前行/列存在0，则该行/列的首行/列位置置0，然后再遍历矩阵，假如该行/列的首个元素为0则该行/列全部置0。
    public static void setZeroes1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // 遍历第一行，判断是否存在0
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // 遍历第一列，判断是否存在0
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // 遍历矩阵，将矩阵中0的行/列的首个元素置0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 遍历矩阵，该行/列的首个元素为0，则该行/列的元素都置0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // 置零第一行
        if (firstRowHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }

        // 置零第一列
        if (firstColHasZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 直观法：记录每个0的行和列
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
