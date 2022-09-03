package day03.sort.qsort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) throws IOException {
        String[] strArray;
        int[] array = new int[10000];
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day03/sort/datafile.txt"));
        String line;
        while ((line=br.readLine())!=null){
            strArray = line.split(",");
            for (int i = 0; i < strArray.length; i++) {
                array[i] = Integer.parseInt(strArray[i]);
            }
        }
        long start = System.nanoTime();
        //用自写快排
        quickSort(array,0,array.length-1);
        long end = System.nanoTime();
        System.out.println("用时:"+(end-start)+"ns");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        temp = arr[low];
        while (i<j) {
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }
}
