package week2.day14.BubbleSort;

import week1.day03.util.ReadFile;

import java.io.IOException;

public class Array {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day14/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 100);
        //用冒泡排序
        bubbling(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void bubbling(int[] array) {
        /**
         * Each j-loop moves the smaller value forward, and each i-loop moves the smallest value to the top of the array
         */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
