package day05.arraySplittingAndMerging;

public class ArraySplittingAndMerging {
    public static void main(String[] args) {
        //Initialize the array to be split and the array to store numbers and letters
        String[] array = {"H", "1", "e", "3", "l", "l", "1", "o", "4"};
        String[] numArray = new String[0];
        String[] characterArray = new String[0];
        for (int size = 0; size < array.length; size++) {
            /**
             * Use ASCL code to determine whether the character is a letter or a number.
             * If both are not, the prompt word will be output
             */
            int ascll = Integer.valueOf(array[size].charAt(0));
            if (((65 <= ascll) && (ascll <= 90)) || ((97 <= ascll) && (ascll <= 122))) {
                characterArray = Dilatation(characterArray, array[size]);
            } else if ((ascll <= 57) && (ascll >= 48)) {
                numArray = Dilatation(numArray, array[size]);
            } else {
                System.out.println("It is detected that the "+size+
                        "th item in the original array does not belong to numbers and letters!");
            }
        }
        //Output the contents of two arrays of letters and numbers
        System.out.print("数字数组：");
        for (int size = 0; size < numArray.length; size++) {
            System.out.print(numArray[size]);
        }
        System.out.println();
        System.out.print("字母数组：");
        for (int size = 0; size < characterArray.length; size++) {
            System.out.print(characterArray[size]);
        }
    }

    public static String[] Dilatation(String[] array, String str) {
        /**
         * Create a new array and endow the old array with the purpose of capacity expansion
         */
        String[] newArray = new String[array.length + 1];
        for (int size = 0; size < array.length; size++) {
            newArray[size] = array[size];
        }
        newArray[array.length] = str;
        return newArray;
    }
}
