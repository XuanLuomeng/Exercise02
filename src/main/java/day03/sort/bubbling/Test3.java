package day03.sort.bubbling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) throws IOException {
        String[] strArray;
        int[] array = new int[100];
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day03/sort/datafile.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            strArray = line.split(",");
            for (int i = 0; i < 100; i++) {
                array[i] = Integer.parseInt(strArray[i]);
            }
        }
        long start = System.nanoTime();
        //用冒泡排序
        bubbling(array);
        long end = System.nanoTime();
        System.out.println("用时:" + (end - start) + "ns");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void bubbling(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
