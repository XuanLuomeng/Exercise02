package day05.horseRaceLamp;

public class OneDimensional {
    public static void main(String[] args) {
        String[] str = {"H", "e", "l", "l", "o", ",", " ", "J", "a", "v", "a", "!"};
        for (int j = 0; j < str.length; j++) {
            System.out.print(str[j]);
        }
        System.out.println();
        for (int i = 0; i < str.length; i++) {
            transposition(str);
            for (int j = 0; j < str.length; j++) {
                System.out.print(str[j]);
            }
            System.out.println();
        }
    }

    public static void transposition(String[] str) {
        String tStr = str[0];
        for (int i = 1; i < str.length; i++) {
            str[i - 1] = str[i];
        }
        str[str.length-1] = tStr;
    }
}
