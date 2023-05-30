package week5.day7;

/**
 * @author LuoXuanwei
 * @date 2023/5/30 19:23
 */
public class Test4 extends Thread {
    public static void main(String[] args) {
        Test4 b = new Test4();
        b.run();
    }

    @Override
    public void start() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Value of i =" + i);
        }
    }
}
