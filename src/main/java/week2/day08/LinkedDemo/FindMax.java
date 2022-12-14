package week2.day08.LinkedDemo;

import week2.day08.linkedListPojo.LinkListClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindMax {
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
        System.out.println("preorderFindMax:" + preorderFind(listClass, 0));
        System.out.println("postorderFindMax:" + postorderFind(listClass, listClass.getSize() - 1));
    }

    /**
     * find by preorder
     *
     * @param listClass
     * @param side
     */
    public static int preorderFind(LinkListClass listClass, int side) {
        int max = (Integer) listClass.getElem(side);
        side++;
        if (side < listClass.getSize() - 1) {
            int temp = preorderFind(listClass, side);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    /**
     * find by postorder
     *
     * @param listClass
     * @param side
     */
    public static int postorderFind(LinkListClass listClass, int side) {
        int max = (Integer) listClass.getElem(side);
        side--;
        if (side >= 0) {
            int temp = postorderFind(listClass, side);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
