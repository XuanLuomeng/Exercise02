package week14.day1;

import java.util.Random;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2025/4/2 18:21
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(3));
        }
    }
}
