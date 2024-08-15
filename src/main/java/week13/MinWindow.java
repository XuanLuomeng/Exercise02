package week13;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/15 20:27
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        StringBuffer res = new StringBuffer(s);
        int resLength = 0;

        for (int left = 0; left < s.length() - t.length(); left++) {
            StringBuffer sb = new StringBuffer();
            String temp = new String(t);
            if (temp.contains(String.valueOf(s.charAt(left)))) {
                sb.append(s.charAt(left));
                temp.replaceFirst(String.valueOf(s.charAt(left)), "");
                for (int right = left + 1; right < s.length(); right++) {
                    if (temp.isEmpty()) {
                        break;
                    }
                    sb.append(s.charAt(right));
                    if (temp.contains(String.valueOf(s.charAt(right)))) {
                        temp.replaceFirst(String.valueOf(s.charAt(right)), "");
                    }
                }
                if (temp.isEmpty() && res.length() > sb.length()) {
                    res = sb;
                }
            }
        }
        return res.toString();
    }
}
