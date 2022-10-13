package day08.LinkedDemo;

import day08.linkedListPojo.LinkListClass;

public class JosephRing {
    public static void main(String[] args) {
        String[] strs = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        LinkListClass<String> listClass = new LinkListClass<>(strs);
        int temp = -1;
        int sign = 0;
        while (sign == 0) {
            if (listClass.getSize() == 1) {
                sign = 1;
            }
            temp += temp == -1 ? 3 : 2;
            while (temp >= listClass.getSize()) {
                temp -= listClass.getSize();
            }
            System.out.print(listClass.getElem(temp) + "\t");
            listClass.delete(temp);
        }
    }
}
