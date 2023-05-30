package week5.day7;

/**
 * @author LuoXuanwei
 * @date 2023/5/30 19:13
 */
public class Test {
    public static void main(String[] args) {
        Fun fun = msg ->
                System.out.println(msg+"World");
        fun.fun("Hello");
    }
}
