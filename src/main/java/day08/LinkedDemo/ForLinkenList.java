package day08.LinkedDemo;

import day08.linkedListPojo.LinkListClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ForLinkenList {
    public static void main(String[] args) throws IOException {
        /**
         * Get the array by reading and writing the file
         */
        int NUM = 20;
        String[] strArray;
        String[] array = new String[NUM];
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day08/file/datafile.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            strArray = line.split(",");
            for (int i = 0; i < NUM; i++) {
                array[i] = strArray[i];
            }
        }
        LinkListClass<String> listClass = new LinkListClass<>(array);
        System.out.println("preorderPrint:");
        preorderPrint(listClass, 0);
        System.out.println();
        System.out.println(" preorderPrint:");
        postorderPrint(listClass, listClass.getSize() - 1);
    }

    /**
     * print by preorder
     * @param listClass
     * @param side
     */
    public static void preorderPrint(LinkListClass listClass, int side) {
        System.out.print(listClass.getElem(side) + "\t");
        side++;
        if (side < listClass.getSize()) {
            preorderPrint(listClass, side);
        }
    }

    /**
     * print by postorder
     * @param listClass
     * @param side
     */
    public static void postorderPrint(LinkListClass listClass, int side) {
        System.out.print(listClass.getElem(side) + "\t");
        side--;
        if (side >= 0) {
            postorderPrint(listClass, side);
        }
    }
}
