package week12.day2;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/7 19:09
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *
 * 每次数组两两进行字符charAt一个一个比较
 * 当比较的长度==0则不存在
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < len; i++) {
            int j = 0;
            for (; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            if (j == 0) {
                return prefix;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
