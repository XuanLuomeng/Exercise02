package week12.day3;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/8 23:16
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 解决方案：string.IndexOf(string)
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int length = needle.length();
        for (int i = 0; i < len; i++) {
            if (len - i < needle.length()) {
                return -1;
            }
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while (j < length && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                if (j == length) {
                    return i;
                }
            }
        }
        return -1;
    }
}
