package week3.day16.heapsort;

import week1.day03.util.ReadFile;

import java.io.IOException;
import java.util.Arrays;

public class Heapsort {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day16/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 10000);
        //heapsort
        heapSort(array);
        //show
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] arr) {
        int len = arr.length;
        // Construct the large top heap
        buildMaxHeap(arr, len);
        // Swap the nodes at the top of the heap and the current end, resetting the large top heap
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
    }

    private static void buildMaxHeap(int[] arr, int len) {
        // The forward traversal starts from the last non leaf node
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        // Find the index of the node
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largestIndex = i;
        //Compare the left and right nodes to find the maximum value
        if (left < len && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }
        if (right < len && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }
        //If the current node is not the maximum value, it swaps positions with the maximum value
        if (largestIndex != i) {
            swap(arr, i, largestIndex);
            heapify(arr, largestIndex, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
