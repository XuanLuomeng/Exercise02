package day05.horseRaceLamp;

public class TwoDimensional {
    public static void main(String[] args) {
        String[][] str = {{"H", "e", "l", "l", "o", ","}, {" ", "J", "a", "v", "a", "!"}};
        for (int i = 0; i < 20; i++) {
            transposition(str);
            for (int j = 0; j < str.length; j++) {
                for (int k = 0; k < str[j].length; k++) {
                    System.out.print(str[j][k]);
                }
                System.out.println();
            }
        }
    }

    public static void transposition(String[][] str) {
        String tStr = str[0][0];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length - 1; j++) {
                if (i == 0) {
                    str[i][j] = str[i][j + 1];
                } else {
                    if (j == 0) {
                        str[i - 1][str[i - 1].length - 1] = str[i][j];
                        str[i][j] = str[i][j + 1];
                    } else {
                        str[i][j] = str[i][j + 1];
                    }
                }
            }
        }
        str[str.length - 1][str[str.length - 1].length - 1] = tStr;
    }
}
