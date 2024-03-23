package week10.day4;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 记忆法学习内容序号
 * @date 2024/3/23 23:20
 */
public class test {
    private static final int today = 13;

    public static void main(String[] args) {
        System.out.println("学习:" + today);
        if (today - 1 > 0) {
            System.out.println("复习:" + (today - 1));
        }
        if (today - 3 > 0) {
            System.out.println("复习:" + (today - 3));
        }
        if (today - 6 > 0) {
            System.out.println("复习:" + (today - 6));
        }
        if (today - 14 > 0) {
            System.out.println("复习:" + (today - 14));
        }
        if (today - 29 > 0) {
            System.out.println("复习:" + (today - 29));
        }
    }
}
