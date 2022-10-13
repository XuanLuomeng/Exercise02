package day08.LinkedDemo;

import day08.linkedListPojo.LinkListClass;
import day08.linkedListPojo.LinkNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Transposite {
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
        for (int size = 0; size < listClass.getSize(); size++) {
            System.out.print(listClass.getElem(size) + "\t");
        }
        //Start Swapping
        for (int size = 0; size < listClass.getSize(); size += 2) {
            if (size == 0) {
                LinkNode node = listClass.getNode(size);
                LinkNode node1 = node.getNext();
                node.setNext(node1.getNext());
                node1.setNext(node);
            } else {
                LinkNode node1 = listClass.getNode(size);
                if (node1.getNext() == null) {
                    break;
                } else if (node1.getNext().getNext() == null) {
                    break;
                }
                LinkNode node = listClass.getNode(size - 1);
                LinkNode node2 = listClass.getNode(size + 1);
                node.setNext(node2);
                node1.setNext(node2.getNext());
                node2.setNext(node1);
            }
        }
        //print result
        System.out.println();
        System.out.println("before:");
        for (int size = 0; size < listClass.getSize(); size++) {
            System.out.print(listClass.getElem(size) + "\t");
        }
    }
}
