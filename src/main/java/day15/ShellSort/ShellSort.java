package day15.ShellSort;

import week1.day03.util.ReadFile;

import java.io.IOException;
import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day15/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 10000);
        //shellSort
        shellSort(array);
        //show
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
