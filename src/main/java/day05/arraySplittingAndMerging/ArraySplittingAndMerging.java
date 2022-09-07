package day05.arraySplittingAndMerging;

public class ArraySplittingAndMerging {
    public static void main(String[] args) {
        String[] array = {"H", "1", "e", "3", "l", "l", "1", "o", "4"};
        String[] numArray = new String[0];
        String[] characterArray = new String[0];
        for (int size = 0; size < array.length; size++) {
            //Judging whether a character is a letter or a number with ASCL code
            int ascll = Integer.valueOf(array[size].charAt(0));
            if (((65 <= ascll) && (ascll <= 90)) || ((97 <= ascll) && (ascll <= 122))) {
                characterArray = Dilatation(characterArray, array[size]);
            } else if ((ascll <= 57) && (ascll >= 48)) {
                numArray = Dilatation(numArray, array[size]);
            } else {
                System.out.println("检测到原数组第" + size + "个不属于数字和字母！");
            }
        }
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
