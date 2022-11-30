package day15.quickSort;

import week1.day03.util.ReadFile;

import java.io.IOException;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day15/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 10000);
        //quickSort
        quickSort(array, 0, array.length - 1);
        //show
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        temp = arr[low];
        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}
