package week1.day06.linkedList;

public class LinkedList {
    public static void main(String[] args) {
        LinkListClass<String> listClass = new LinkListClass<>();
        String[] num = {"12", "22", "32", "43", "23", "49"};
        listClass.createListTop(num);
        System.out.println(listClass.getElem(3));
        System.out.println(listClass.getElem(6));
    }
}
