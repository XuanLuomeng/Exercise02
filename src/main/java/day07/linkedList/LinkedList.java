package day07.linkedList;

public class LinkedList {
    public static void main(String[] args) {
        /**
         * Initialize a linked list
         */
        LinkListClass<String> listClass = new LinkListClass<>();
        String[] num = {"12", "22", "32", "43", "23", "49", "32"};
        //Put an array into a linked list
        listClass.createListTop(num);
        //Output the contents of the linked list with subscript 4
        System.out.println(listClass.getElem(4));
        //find content
        listClass.find("32");
        //insert copy in front
        listClass.nextCopy("32");
        //Output the linked
        System.out.println("The result of the copy:");
        for (int i = 0; i < listClass.size(); i++) {
            System.out.print(listClass.getElem(i) + "\t");
        }
        //insert copy after that
        listClass.lastCopy("23");
        //Output the linked
        System.out.println();
        System.out.println("The result of the copy:");
        for (int i = 0; i < listClass.size(); i++) {
            System.out.print(listClass.getElem(i) + "\t");
        }
        System.out.println();
        //Targeted deletion
        listClass.delete(0);
        listClass.delete(8);
        listClass.delete(4);
        //Output the linked
        System.out.println("Directed deletion result:");
        for (int i = 0; i < listClass.size(); i++) {
            System.out.print(listClass.getElem(i) + "\t");
        }
        //Precursors to delete
        System.out.println();
        listClass.nextDelete(1);
        listClass.nextDelete(6);
        listClass.nextDelete(3);
        System.out.println("Result of deleting the precursor:");
        //Output the linked
        for (int i = 0; i < listClass.size(); i++) {
            System.out.print(listClass.getElem(i) + "\t");
        }
        //After flooding to delete
        System.out.println();
        listClass.lastDelete(-1);
        listClass.lastDelete(1);
        //Output the linked
        System.out.println("Result of deleting the rear drive:");
        for (int i = 0; i < listClass.size(); i++) {
            System.out.print(listClass.getElem(i) + "\t");
        }
    }
}
