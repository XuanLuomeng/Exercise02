package day08.LinkedDemo;

import day08.linkedListPojo.LinkListClass;

public class Merge {
    public static void main(String[] args) {
        String[] nums = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        LinkListClass<String> num = new LinkListClass<>(nums);
        LinkListClass<String> letter = new LinkListClass<>(letters);
        LinkListClass<String> strs = new LinkListClass<>();
        int temp = num.getSize() > letter.getSize() ? num.getSize() : letter.getSize();
        for (int size = 0; size < temp; size++) {
            if (size < num.getSize()) {
                strs.Insert(num.getElem(size));
            }
            if (size < letter.getSize()) {
                strs.Insert(letter.getElem(size));
            }
        }
        System.out.println("print:");
        for (int size = strs.getSize() - 1; size >= 0; size--) {
            System.out.print(strs.getElem(size) + "\t");
        }
    }
}
