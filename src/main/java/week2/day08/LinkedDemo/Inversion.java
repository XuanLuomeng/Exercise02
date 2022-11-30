package week2.day08.LinkedDemo;

import week2.day08.linkedListPojo.LinkListClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Inversion the Linked
 */
public class Inversion {
    public static void main(String[] args) throws IOException {
        /**
         * Get the array by reading and writing the file
         */
        int NUM = 20;
        String[] strArray;
        Integer[] array = new Integer[NUM];
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day08/file/datafile.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            strArray = line.split(",");
            for (int i = 0; i < NUM; i++) {
                array[i] = Integer.valueOf(strArray[i]);
            }
        }
        LinkListClass<Integer> listClass = new LinkListClass<>(array);
        System.out.println("after:");
        for (int size = listClass.getSize() - 1; size >= 0; size--) {
            System.out.print(listClass.getElem(size) + "\t");
        }
        System.out.println();
        LinkListClass<Integer> listClass1 = new LinkListClass<>();
        for (int size = listClass.getSize() - 1; size >= 0; size--) {
            listClass1.Insert(listClass.getElem(size));
        }
        System.out.println("before");
        for (int size = listClass.getSize() - 1; size >= 0; size--) {
            System.out.print(listClass1.getElem(size) + "\t");
        }
    }
}
