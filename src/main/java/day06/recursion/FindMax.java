package day06.recursion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindMax {
    public static void main(String[] args) throws IOException {
        /**
         * Get the array by reading and writing the file
         */
        int maxNum = 0;
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
        maxNum = findMax(array, 0);
        System.out.println(maxNum);
    }

    /**
     * Each recursion returns a maximum number
     *
     * @param array
     * @param num
     * @return
     */
    public static int findMax(int[] array, int num) {
        int max = 0;
        if (num < array.length) {
            int nextNum = findMax(array, num + 1);
            max = array[num] > nextNum ? array[num] : nextNum;
        }
        return max;
    }
}
