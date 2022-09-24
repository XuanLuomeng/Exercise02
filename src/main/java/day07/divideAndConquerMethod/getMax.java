package day07.divideAndConquerMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class getMax {
    public static void main(String[] args) throws IOException {
        /**
         * Get the array by reading and writing the file
         */
        final int NUM = 1000;
        String[] strArray;
        int[] array = new int[NUM];
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day07/datafile.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            strArray = line.split(",");
            for (int i = 0; i < NUM; i++) {
                array[i] = Integer.parseInt(strArray[i]);
            }
        }
        int[] ar = dacm(array);
        for (int size = 0; size < ar.length; size++) {
            System.out.println(ar[size]);
        }
    }

    /**
     * Split the array, split the left and right to find the maximum value respectively
     * @param array
     * @return
     */
    public static int[] dacm(int[] array) {
        if (array.length == 1) {
            return array;
        }else {
            int middle = array.length / 2;
            int[] arr1 = new int[middle];
            int[] arr2 = new int[array.length - middle];
            for (int size = 0; size < middle; size++) {
                arr1[size] = array[size];
            }
            int lift = maxSub(arr1);
            int liftNum = middle - lift;
            for (int size = 0; size < array.length - middle; size++) {
                arr2[size] = array[middle + size];
            }
            int rightNum = maxSub(arr2);
            int[] arr3 = new int[rightNum + liftNum];
            for (int size = 0; size < rightNum + liftNum; size++) {
                arr3[size] = array[lift + size];
            }
            return dacm(arr3);
        }
    }

    /**
     * Find the subscript of the maximum value
     * @param array
     * @return
     */
    public static int maxSub(int[] array) {
        int max = 0;
        int sign = 0;
        for (int size = 0; size < array.length; size++) {
            if (array[size] > max) {
                max = array[size];
                sign = size;
            }
        }
        return sign;
    }
}
