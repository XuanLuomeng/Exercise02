package day03.day04;

public class Test01 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass(0);
        System.out.println(myClass);

    }
    public static void fun1(MyClass myClass){
        myClass = new MyClass(1);
    }
}
