package week12.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/8 22:15
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 解决方案：
 * 设置index作为当前字符存储第index行
 * 设置一个sign作为±1；当index除于行数结果为0或者为length-1时，sign变换符号
 * index 等于自身加sign
 */
public class Convert {
    private static final String s = "PAYPALISHIRING";

    public static void main(String[] args) {
        String convert = convert(s, 3);
        //PAHNAPLSIIGYIR
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        List<StringBuffer> strings = new ArrayList<>();
        int index = 0;
        int sign = 1;

        if (numRows == 1) {
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            strings.add(new StringBuffer());
        }

        for (char cha : s.toCharArray()) {
            strings.get(index).append(cha);
            index += sign;
            if (index == 0 || index == numRows - 1) {
                sign = -sign;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for(StringBuffer sb : strings){
            stringBuffer.append(sb);
        }

        return stringBuffer.toString();
    }
}
