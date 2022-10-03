package day08.LinkedDemo;

import day08.linkedListPojo.TwoWayLinkListClass;

public class TwoWayLinkDemo {
    public static void main(String[] args) {
        String[] strs = new String[]{"1","2","3","4","5"};
        TwoWayLinkListClass<String> listClass = new TwoWayLinkListClass<>(strs);
        System.out.println("after:");
        for (int size = 0; size < listClass.getSize(); size++) {
            System.out.print(listClass.getElem(size)+"\t");
        }
        System.out.println();
        listClass.Insert("6");
        System.out.println("Insert before:");
        for (int size = 0; size < listClass.getSize(); size++) {
            System.out.print(listClass.getElem(size)+"\t");
        }
        System.out.println();
        listClass.delete(3);
        System.out.println("Delete before:");
        for (int size = 0; size < listClass.getSize(); size++) {
            System.out.print(listClass.getElem(size)+"\t");
        }
        System.out.println();
        System.out.println("Demo:");
        System.out.println("getNode(3).getLast().getData():"+listClass.getNode(3).getLast().getData());
        System.out.println("getNode(3).getNext().getData():"+listClass.getNode(3).getNext().getData());
    }
}
