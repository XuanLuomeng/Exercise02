package week3.day16.bucketsort;

import week1.day03.util.ReadFile;

import java.io.IOException;
import java.util.*;

public class Bucketsort {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day16/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 10000);
        //bucketSort
        bucketSort(array);
        //show
        System.out.println(Arrays.toString(array));
    }

    public static void bucketSort(int[] arr) {
        int maxNum = arr[0];
        int minNum = arr[0];
        for (int j : arr) {
            if (j > maxNum) {
                maxNum = j;
            }
            if (j < minNum) {
                minNum = j;
            }
        }
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < maxNum - minNum + 1; i++) {
            //Create a new bucket and add it to the set of buckets.
            //Because buckets are frequently inserted, we chose LinkedList as the data structure for the bucket
            buckets.add(new LinkedList<>());
        }
        //Put all the input data in the bucket and finish sorting
        for (int data : arr) {
            int index = maxNum - data;
            buckets.get(index).add(data);
        }
        //Take all the elements out of the bucket and put them into arr for output
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            for (Integer data : bucket) {
                arr[index++] = data;
            }
        }
    }
}
