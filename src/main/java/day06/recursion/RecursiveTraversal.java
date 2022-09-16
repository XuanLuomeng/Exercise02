package day06.recursion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecursiveTraversal {
    public static void main(String[] args) throws IOException {
        /**
         * Use file read/write to obtain array
         */
        String[] strArray;
        int[] array = new int[100];
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day06/datafile.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            strArray = line.split(",");
            for (int i = 0; i < 100; i++) {
                array[i] = Integer.parseInt(strArray[i]);
            }
        }
        mainShow(array, 0);
        System.out.println();
        antitoneShow(array, array.length - 1);
    }

    /**
     * Stop recursion when subscript reaches the upper limit of array length
     *
     * @param array
     * @param num
     */
    public static void mainShow(int[] array, int num) {
        System.out.print(array[num] + ",");
        if (num < array.length - 1) {
            mainShow(array, num + 1);
        }
    }

    /**
     * Stop recursion when subscript reaches the lower limit of array length
     *
     * @param array
     * @param num
     */
    public static void antitoneShow(int[] array, int num) {
        System.out.print(array[num] + ",");
        if (num > 0) {
            antitoneShow(array, num - 1);
        }
    }
}
