package day08.LinkedDemo;


import day08.linkedListPojo.LinkListClass;
import day08.linkedListPojo.LinkNode;

/**
 * Split numbers and letters
 */
public class Classificate {
    public static void main(String[] args) {
        String[] str = new String[]{"h", "2", "a", "0", "D", "3", "l", "O", "6"};
        LinkListClass<String> listClass = new LinkListClass<>(str);
        show(listClass);
    }

    public static void show(LinkListClass listClass) {
        LinkListClass<String> num = new LinkListClass<>();
        LinkListClass<String> strs = new LinkListClass<>();
        for (int size = 0; size < listClass.getSize(); size++) {
            String str = listClass.getElem(size).toString();
            if (str.charAt(0) >= 48 && str.charAt(0) <= 57) {
                LinkNode<String> node = new LinkNode<>(str);
                num.add(node);
            } else if (str.toUpperCase().charAt(0) >= 65 && str.toUpperCase().charAt(0) <= 90) {
                LinkNode<String> node = new LinkNode<>(str);
                strs.add(node);
            } else {
                System.out.println(str + " non alphabetic and non numeric!");
            }
        }
        System.out.println("Ordinal number:");
        for (int size = 0; size < num.getSize(); size++) {
            System.out.print(num.getElem(size) + "\t");
        }
        System.out.println();
        System.out.println("Sequential letter:");
        for (int size = 0; size < strs.getSize(); size++) {
            System.out.print(strs.getElem(size) + "\t");
        }
        System.out.println();
        System.out.println("Number in reverse order:");
        for (int size = num.getSize() - 1; size >= 0; size--) {
            System.out.print(num.getElem(size) + "\t");
        }
        System.out.println();
        System.out.println("Reversed letter:");
        for (int size = strs.getSize() - 1; size >= 0; size--) {
            System.out.print(strs.getElem(size) + "\t");
        }
    }
}
