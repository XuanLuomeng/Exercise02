package week2.day14.SelectionSort;

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
        //用选择排序
        selectSort(listClass);
        for (int i = 0; i < listClass.size(); i++) {
            System.out.println(listClass.getElem(i));
        }
    }

    public static void selectSort(LinkListClass listClass) {
        /**
         * Locate the list of minimum values and the index in turn, and then place it at the top of the original list
         */
        int size = listClass.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            LinkNode min = listClass.getNode(i);
            for (int j = i + 1; j < size; j++) {
                if (Integer.parseInt((String) min.data) >
                        Integer.parseInt((String) listClass.getNode(j).data)) {
                    min = listClass.getNode(j);
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                listClass.getNode(minIndex - 1).next = min.next;
                min.next = listClass.getNode(i);
                listClass.getNode(i - 1).next = min;
            }
        }
    }
}
