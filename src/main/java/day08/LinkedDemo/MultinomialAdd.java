package day08.LinkedDemo;

import day08.linkedListPojo.MultinomialLinkListClass;
import day08.linkedListPojo.MultinomialLinkNode;

public class MultinomialAdd {
    public static void main(String[] args) {
        int[] index1 = new int[]{1, 2, 3};
        int[] coef1 = new int[]{3, 2, 1};
        int[] index2 = new int[]{3, 2, 1};
        int[] coef2 = new int[]{1, 2, 3};
        MultinomialLinkListClass listClass1 = new MultinomialLinkListClass(coef1, index1);
        MultinomialLinkListClass listClass2 = new MultinomialLinkListClass(coef2, index2);
        MultinomialLinkListClass listClass = new MultinomialLinkListClass();
        for (int size = 0; size < listClass1.getSize(); size++) {
            //Get index and coefficient
            int[] temp = listClass1.getElem(size);
            System.out.print(temp[0] + "x^" + temp[1] + "\t");
            listClass.add(new MultinomialLinkNode(temp[0], temp[1]));
        }
        System.out.println();
        for (int size = 0; size < listClass2.getSize(); size++) {
            //Get index and coefficient
            int[] temp = listClass2.getElem(size);
            System.out.print(temp[0] + "x^" + temp[1] + "\t");
            listClass.add(new MultinomialLinkNode(temp[0], temp[1]));
        }
        System.out.println();
        System.out.println("add after:");
        for (int size = 0; size < listClass.getSize(); size++) {
            int[] temp = listClass.getElem(size);
            System.out.print(temp[0] + "x^" + temp[1] + "\t");
        }
    }
}
