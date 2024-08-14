package week12.day7;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/14 22:30
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int len = s.length();
        int res = Integer.MIN_VALUE;
        String winString = "";
        while (right < len) {
            String str = String.valueOf(s.charAt(right));
            int index = winString.indexOf(str);
            if (index != -1) {
                left += index + 1;
                winString = winString.substring(index + 1, winString.length());
            }

            res = Math.max(res, right - left);

            winString += str;

            right++;
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
