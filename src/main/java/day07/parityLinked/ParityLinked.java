package day07.parityLinked;

import day07.linkedList.LinkListClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParityLinked {
    public static void main(String[] args) throws IOException {
        /**
         * Get the array by reading and writing the file
         */
        final int NUM = 100;
        String[] strArray;
        Integer[] array = new Integer[NUM];
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day07/datafile.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            strArray = line.split(",");
            for (int i = 0; i < NUM; i++) {
                array[i] = Integer.parseInt(strArray[i]);
            }
        }
        //Put array into linked list
        LinkListClass<Integer> link = new LinkListClass<>();
        link.createListTop(array);
        int arSign = array.length;
        /**
         * Cyclic judgment, delete the even number in the linked list,
         * and add a linked list value after the odd number to add one to the odd number
         */
        for (int size = 0; size < arSign; size++) {
            Integer sign = link.getElem(size);
            if (sign % 2 != 0) {
                link.Insert(size + 1, sign + 1);
                arSign++;
                size++;
            } else {
                link.delete(size);
                arSign--;
                size--;
            }
        }
        for (int size = 0; size < link.size(); size++) {
            System.out.println(link.getElem(size) + "\t");
        }
    }
}
