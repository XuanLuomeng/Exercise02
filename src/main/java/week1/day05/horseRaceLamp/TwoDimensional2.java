package week1.day05.horseRaceLamp;

public class TwoDimensional2 {
    public static void main(String[] args) {
        int total = 0;
        String[][] str = {{"1", "2", "3", "4", "5", "6", "7", "8"},
                {"28", "a", "b", "c", "d", "e", "f", "9"},
                {"27", "u", "1", "2", "3", "4", "g", "10"},
                {"26", "t", "12", "a", "b", "5", "h", "11"},
                {"25", "s", "11", "d", "c", "6", "j", "12"},
                {"24", "r", "10", "9", "8", "7", "k", "13"},
                {"23", "q", "p", "o", "m", "n", "l", "14"},
                {"22", "21", "20", "19", "18", "17", "16", "15"}};
        /**
         * Cycle the transposition operation and output the number of cycles until the positions of the four layers of
         * characters are restored to the original positions
         */
        while (true) {
            transposition(str, 0);
            transposition(str, 1);
            transposition(str, 2);
            transposition(str, 3);
            for (int row = 0; row < str.length; row++) {
                for (int cols = 0; cols < str[row].length; cols++) {
                    System.out.print(str[row][cols] + "\t");
                }
                System.out.println();
            }
            total++;
            System.out.println("第"+total+"次换位");
            if (str[0][0].equals("1") && str[1][1].equals("a") && str[2][2].equals("1") && str[3][3].equals("a")) {
                break;
            }
        }
    }

    /**
     * First get a number from a certain layer, and then push all the subsequent numbers forward one space.
     * After the operation is completed, place the obtained number at the position where the character is missing
     * @param str
     * @param layers
     */
    public static void transposition(String[][] str, int layers) {
        String top = str[layers][layers];
        for (int cols = layers; cols < str[0].length - 1 - layers; cols++) {
            str[layers][cols] = str[layers][cols + 1];
        }
        for (int rows = layers; rows < str.length - 1 - layers; rows++) {
            str[rows][str.length - 1 - layers] = str[rows + 1][str.length - 1 - layers];
        }
        for (int cols = str[7].length - 1 - layers; cols > layers; cols--) {
            str[str.length - 1 - layers][cols] = str[str.length - 1 - layers][cols - 1];
        }
        for (int rows = str.length - 1 - layers; rows > layers; rows--) {
            str[rows][layers] = str[rows - 1][layers];
        }
        str[1 + layers][layers] = top;
    }
}
