package day15.insertSort;

import week1.day03.util.ReadFile;

import java.io.IOException;
import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day15/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file,10000);
        //insertSort
        insertSort(array);
        //show
        System.out.println(Arrays.toString(array));
    }

    /**
     * First, set an ascending range of size 1, and then gradually increase the size by 1,
     * and take the last number in the ascending range by 1 each time.
     * All the numbers are gradually put back until the number is no longer less than the number of the pointer position,
     * and the number is placed behind the pointer position.
     * @param arr
     */
    public static void insertSort(int[] arr){
        for (int size = 1; size < arr.length; size++) {
            int insertValue = arr[size];
            int pointer = size - 1;
            for(; pointer >=0 && insertValue < arr[pointer]; pointer--){
                arr[pointer+1] = arr[pointer];
            }
            arr[pointer+1] = insertValue;
        }
    }
}
