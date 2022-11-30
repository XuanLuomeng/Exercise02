package week2.day14.BubbleSort;

import week2.day14.linkedList.LinkListClass;
import week2.day14.linkedList.LinkNode;
import week1.day03.util.ReadFile;

import java.io.IOException;

public class List {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day14/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 100);
        String[] arrayStr = new String[100];
        for (int i = 0; i < array.length; i++) {
            arrayStr[i] = String.valueOf(array[i]);
        }
        LinkListClass<String> listClass = new LinkListClass<>();
        listClass.createListTop(arrayStr);
        //用冒泡排序
        bubbling(listClass);
        for (int i = 0; i < listClass.size(); i++) {
            System.out.println(listClass.getElem(i));
        }
    }

    public static void bubbling(LinkListClass listClass) {
        /**
         * Each j-loop moves the smaller value forward, and each i-loop moves the smallest value to the top of the list
         */
        int size = listClass.size();
        LinkNode last = null;
        LinkNode node = null;
        LinkNode next = null;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (Integer.parseInt((String) listClass.getElem(j)) > Integer.parseInt((String) listClass.getElem(j + 1))) {
                    if (j == 0) {
                        node = listClass.getNode(j);
                        next = listClass.getNode(j + 1);
                        node.next = next.next;
                        next.next = node;
                        listClass.head = next;
                    } else {
                        last = listClass.getNode(j - 1);
                        node = listClass.getNode(j);
                        next = listClass.getNode(j + 1);
                        last.next = next;
                        node.next = next.next;
                        next.next = node;
                    }
                }
            }
        }
    }
}
