package day06;

public class magicSquare {
    public static void main(String[] args) {
        /**
         * Initialize array
         */
        int[][] array = new int[5][5];
        for (int row = 0; row < array.length; row++) {
            for (int cols = 0; cols < array[row].length; cols++) {
                array[row][cols] = 0;
            }
        }
        /**
         * Start to put 1-n * n, total n * n numbers
         */
        int row = 0;
        int cols = array.length / 2;
        int rowTemp;
        int colsTemp;
        for (int time = 1; time <= array.length * array.length; time++) {
            array[row][cols] = time;
            rowTemp = row - 1;
            colsTemp = cols + 1;
            if (rowTemp < 0) {
                rowTemp = array.length - 1;
            }
            if (colsTemp > 4) {
                colsTemp = 0;
            }
            if (array[rowTemp][colsTemp] != 0) {
                row++;
            } else {
                row = rowTemp;
                cols = colsTemp;
            }
        }
        /**
         * Output results
         */
        for (int ro = 0; ro < array.length; ro++) {
            for (int co = 0; co < array[ro].length; co++) {
                System.out.print(array[ro][co] + "\t");
            }
            System.out.println();
        }
    }
}
