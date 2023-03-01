package week3.day15.MergeSort;

import week1.day03.util.ReadFile;

import java.io.IOException;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day15/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 10000);
        //mergeSort
        mergeSort(array, 0, array.length - 1);
        //show
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int[] newArray = new int[right - left + 1];
        int pointer = 0;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] <= arr[s2]) {
                newArray[pointer++] = arr[s1++];
            } else {
                newArray[pointer++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            newArray[pointer++] = arr[s1++];
        }
        while (s2 <= right) {
            newArray[pointer++] = arr[s2++];
        }
        for (int i = 0; i < newArray.length; i++) {
            arr[i + left] = newArray[i];
        }
    }
}
