package week14.day5;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 赎金信
 * @date 2025/9/17 22:21
 *
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class CanConstruct {

    private static String ransomNote = "aa";

    private static String magazine = "aab";

    public static void main(String[] args) {
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 创建一个长度为26的数组，用于记录ransomNote中每个字母查找的索引起点位置
        // 因为字符串中只包含小写字母，所以字符串中的单个字符减去 'a' 的值，可以作为数组的索引
        int[] letter = new int[26];

        int n = ransomNote.length();

        for (int i = 0; i < n; i++) {
            char ch = ransomNote.charAt(i);
            int index = magazine.indexOf(ch, letter[ch - 'a']);
            if (index == -1) {
                return false;
            }else {
                letter[ch - 'a'] = index + 1;
            }
        }

        return true;
    }
}
