package week13.day3;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2025/3/6 22:40
 */

/**
 * 小天才笔试题之一
 * 答案是：staticA staticB staticC
 */
public class Test {

    static {
        System.out.println("staticA");
    }

    public static void main(String[] args) {
        printC();
    }

    static {
        System.out.println("staticB");
    }

    static void printC(){
        System.out.println("staticC");
    }
}
