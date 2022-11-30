package week2.day14.SelectionSort;

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
        //用选择排序
        selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void selectSort(int[] arr) {
        /**
         * Locate the array of minimum values and the index in turn, and then place it at the top of the original array
         */
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
