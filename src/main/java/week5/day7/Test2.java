package week5.day7;

/**
 * @author LuoXuanwei
 * @date 2023/5/30 19:17
 */
public class Test2 {
    static int cnt = 6;

    static {
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println("cnt=" + cnt);
    }

    static {
        cnt /= 3;
    }
}
