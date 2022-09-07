package day05.horseRaceLamp;

public class TwoDimensional {
    public static void main(String[] args) {
        String[][] str = {{"01", "02", "03", "04"}, {"05", "06", "07", "08"},
                {"09", "10", "11", "12"}, {"13", "14", "15", "16"}};
        //The code is executed 16 times, and 01 returns to the initial position
        for (int run = 0; run < 16; run++) {
            transposition(str);
            //Output the result every time the position transfer code is executed
            for (int row = 0; row < str.length; row++) {
                for (int cols = 0; cols < str[row].length; cols++) {
                    System.out.print(str[row][cols]+"\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void transposition(String[][] str) {
        /**
         * First extract the last content of the running lantern route,
         * then let all the contents of the array be overwritten once according to the running lantern route,
         * and finally assign the extracted last content to the first position of the array
         *
         * Route(The symbol "*" indicates that the position changes to coordinates (0, 0)):
         * ↓ ↓ ← ←
         * ↓ ↓ * ↑
         * ↓ → ↑ ↑
         * → → → ↑
         */
        String tStr = str[1][2];
        str[1][2] = str[2][2];
        str[2][2] = str[2][1];
        for (int row = 2; row > 0; row--) {
            str[row][1] = str[row - 1][1];
        }
        for (int clos = 1; clos < 3; clos++) {
            str[0][clos] = str[0][clos + 1];
        }
        for (int row = 0; row < 3; row++) {
            str[row][3] = str[row + 1][3];
        }
        for (int clos = 3; clos > 0; clos--) {
            str[3][clos] = str[3][clos - 1];
        }
        for (int row = 3; row > 0; row--) {
            str[row][0] = str[row - 1][0];
        }
        str[0][0] = tStr;
    }
}
