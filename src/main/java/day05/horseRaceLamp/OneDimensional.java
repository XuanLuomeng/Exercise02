package day05.horseRaceLamp;

public class OneDimensional {
    public static void main(String[] args) {
        String[] str = {"H", "e", "l", "l", "o", ",", " ", "J", "a", "v", "a", "!"};
        //Output original content
        for (int size = 0; size < str.length; size++) {
            System.out.print(str[size]);
        }
        System.out.println();
        for (int run = 0; run < str.length; run++) {
            //Call method
            transposition(str);
            //Output content
            for (int size = 0; size < str.length; size++) {
                System.out.print(str[size]);
            }
            System.out.println();
        }
    }

    public static void transposition(String[] str) {
        String tStr = str[0];
        //The first character is placed at the end of the array, and the rest of the array is pushed forward one space
        for (int position = 1; position < str.length; position++) {
            str[position - 1] = str[position];
        }
        str[str.length - 1] = tStr;
    }
}
