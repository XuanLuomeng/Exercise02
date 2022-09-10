package day05.listArray;

public class ListArray {
    public static void main(String[] args) {
        SqListClass<String> sqListClass = new SqListClass<>();
        sqListClass.append("hello");
        System.out.println(sqListClass.find("hello"));
        sqListClass.insert("java",1);
        System.out.println(sqListClass.search("java"));
        System.out.println(sqListClass.loc(0));
        sqListClass.delete("hello");
        System.out.println(sqListClass.loc(0));
        System.out.println(sqListClass.search("hello",0));
    }
}
