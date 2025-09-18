package week14.day6;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 同构字符串
 * @date 2025/9/18 20:42
 *
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] s1 = new int[256];
        int[] t1 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s1[s.charAt(i)] != t1[t.charAt(i)]) {
                return false;
            }
            s1[s.charAt(i)] = i + 1;
            t1[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
