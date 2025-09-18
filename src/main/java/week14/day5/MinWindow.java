package week14.day5;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 最小覆盖子串
 * @date 2025/9/17 23:11
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 滑动窗口算法(双指针)
 * 循环操作(直到右指针超过数组大小)：移动右指针直到所有字符均被覆盖，然后移动左指针。
 */
public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
//        String s = "a", t = "a";
        System.out.println("'" + minWindow(s, t) + "'");
    }

    public static String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if (n < m) {
            return "";
        }

        int[] letter = new int[123];
        for (char c : t.toCharArray()) {
            letter[c]++;
        }

        // 左右指针
        int left = 0, right = 0;
        // 结果字符串大小
        int resLength = Integer.MAX_VALUE;
        // 已匹配的字符数
        int match = 0;
        // 已匹配的首个字符位置
        int start = 0;

        while (right < n) {
            char ch = s.charAt(right);
            if (letter[ch] > 0) {
                match++;
            }
            letter[ch]--;

            while (match == m) {
                // 判断是否满足更小字串
                if (right - left + 1 < resLength) {
                    resLength = right - left + 1;
                    start = left;
                }
                // 将左指针的字符放回letter数组中
                letter[s.charAt(left)]++;
                // 假如缩小左指针导致离开的字符是被匹配到的字符，则已匹配的字符数减一
                if (letter[s.charAt(left)] > 0) {
                    match--;
                }
                // 缩小左指针
                left++;
            }
            right++;
        }

        return resLength == Integer.MAX_VALUE ? "" : s.substring(start, start + resLength);
    }
}
