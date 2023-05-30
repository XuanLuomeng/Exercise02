package week5.day7;

/**
 * @author LuoXuanwei
 * @date 2023/5/30 19:16
 */
public class Test1 {
    public static void main(String[] args) {
        String s1 = "xiaopeng";
        String s2 = "xiaopeng";
        String s3 = new String(s1);
        System.out.println(s1==s2);
        System.out.println(s2==s3);
    }
}
