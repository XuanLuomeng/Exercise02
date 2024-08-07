package week12.day1;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/6 16:52
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        StringBuffer string = new StringBuffer(s);
        int len = string.length();
        int index = 0;
        while (true) {
            index = string.lastIndexOf(" ");
            if (index != len - 1) {
                break;
            }
            string.deleteCharAt(index);
            len--;
        }
        return len - index - 1;
    }
}
