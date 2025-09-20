package week15.day1;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 有效的字母异位词
 * @date 2025/9/20 15:34
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。(仅包含小写字母)
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram2(s, t));
    }

    // 思路1：
    // 1. 创建一个长度为26的数组，记录s中每个字母出现的次数
    // 2. 遍历t，将t中每个字母出现的次数减1
    // 3. 遍历数组，如果数组中某个元素不为0，则返回false
    // 4. 返回true
    // 优点：
    // 实现思路简单，耗时较低，适合大部分数据
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int len = s.length();
        int[] letter = new int[26];

        for (int i = 0; i < len; i++) {
            letter[s.charAt(i) - 'a']++;
            letter[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letter[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // 思路2：
    // 1. 创建一个长度为26的数组，记录s中每个字母在t中出现的位置
    // 2. 通过数组中每个字母在t中出现的位置，判断s中是否有该字母
    // 3. 如果有该字母，则返回true
    // 4. 如果没有该字母，则返回false
    //
    // 用时间换空间，较低空间复杂度
    // 假如大部分数据不属于字母异位词，耗时较低，因为判断较前的字母在另一个数组中不存在时，会提前结束循环，节省时间。
    // 假如大部分数据都属于字母异位词，则耗时较高，因为indexOf底层是通过for遍历String的value数组。
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int len = s.length();

        int[] letter = new int[26];

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int index = t.indexOf(ch, letter[ch - 'a']);
            if (index == -1) {
                return false;
            }else {
                letter[ch - 'a'] = index + 1;
            }
        }
        return true;
    }
}
