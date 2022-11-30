package day15.quickSort;

import week1.day03.util.ReadFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MergeQuickSort {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file1 = "src/main/java/day15/datafile1.txt";
        int[] array1;
        ReadFile rf1 = new ReadFile();
        array1 = rf1.read(file1, 2500);
        //quickSort
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));
        /**
         * Get an array from a file
         */
        String file2 = "src/main/java/day15/datafile2.txt";
        int[] array2;
        ReadFile rf2 = new ReadFile();
        array2 = rf2.read(file2, 2500);
        //quickSort
        quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
        /**
         * Get an array from a file
         */
        String file3 = "src/main/java/day15/datafile3.txt";
        int[] array3;
        ReadFile rf3 = new ReadFile();
        array3 = rf3.read(file3, 2500);
        //quickSort
        quickSort(array3, 0, array3.length - 1);
        System.out.println(Arrays.toString(array3));
        /**
         * Get an array from a file
         */
        String file4 = "src/main/java/day15/datafile4.txt";
        int[] array4;
        ReadFile rf4 = new ReadFile();
        array4 = rf4.read(file4, 2500);
        //quickSort
        quickSort(array4, 0, array4.length - 1);
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
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/day15/quick.txt"));
        for (int i = 0; i < array.length; i++) {
            bufferedWriter.write(array[i]+",");
            bufferedWriter.flush();
        }
        bufferedWriter.close();
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
