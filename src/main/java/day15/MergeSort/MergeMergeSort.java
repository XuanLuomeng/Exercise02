package day15.MergeSort;

import week1.day03.util.ReadFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MergeMergeSort {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file1 = "src/main/java/day15/datafile1.txt";
        int[] array1;
        ReadFile rf1 = new ReadFile();
        array1 = rf1.read(file1, 2500);
        //mergeSort
        mergeSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));
        /**
         * Get an array from a file
         */
        String file2 = "src/main/java/day15/datafile2.txt";
        int[] array2;
        ReadFile rf2 = new ReadFile();
        array2 = rf2.read(file2, 2500);
        //mergeSort
        mergeSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
        /**
         * Get an array from a file
         */
        String file3 = "src/main/java/day15/datafile3.txt";
        int[] array3;
        ReadFile rf3 = new ReadFile();
        array3 = rf3.read(file3, 2500);
        //mergeSort
        mergeSort(array3, 0, array3.length - 1);
        System.out.println(Arrays.toString(array3));
        /**
         * Get an array from a file
         */
        String file4 = "src/main/java/day15/datafile4.txt";
        int[] array4;
        ReadFile rf4 = new ReadFile();
        array4 = rf4.read(file4, 2500);
        //mergeSort
        mergeSort(array4, 0, array4.length - 1);
        System.out.println(Arrays.toString(array4));
        int[] array = new int[10000];
        for (int i = 0; i < 10000; i++) {
            if(i<2500){
                array[i]=array1[i];
            }else if (i<5000){
                array[i]=array2[i-2500];
            }else if(i<7500){
                array[i]=array3[i-5000];
            }else {
                array[i]=array4[i-7500];
            }
        }
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/day15/merge.txt"));
        for (int i = 0; i < array.length; i++) {
            bufferedWriter.write(array[i]+",");
            bufferedWriter.flush();
        }
        bufferedWriter.close();
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
