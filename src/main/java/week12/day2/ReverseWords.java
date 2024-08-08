package week12.day2;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/7 20:03
 * <p>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class ReverseWords {
    //方法一：自写
    public String reverseWords(String s) {
        String[] strs = s.split("[ ]+");
        int len = strs.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = len - 1; i >= 0; i--) {
            if (strs[i] != "") {
                stringBuffer = stringBuffer.append(strs[i] + " ");
            }
        }
        int length = stringBuffer.length();
        return stringBuffer.replace(length - 1, length, "").toString();
    }

    //方法二：最快解决方法
    public String preferredPlan(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] chs = new char[len + 1];
        int index = 0;
        for (int i = len - 1; i >= 0; i--) {
            int r = 0;
            while (chars[i] == ' ' && i > 0) {
                i--;
            }
            r = i;
            while (chars[i] != ' ' && i > 0) {
                i--;
            }
            for (int j = i + 1; j <= r; j++) {
                chs[index++] = chars[j];
                if (index != len) {
                    chs[index++] = ' ';
                }
            }
        }
        return new String(chs, 0, index - 1);
    }
}
