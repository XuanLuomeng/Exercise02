package week12.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/9 21:44
 * <p>
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 解决方法：
 * 先解决最简单的步骤：当行为最后一行，因为最后一行操作最简单只需要填满空格，然后返回结果
 * 然后解决该行只有一个单词，因为其只需要填满空格
 * 最后解决多个单词的行，建议一个单词一个单词拼接
 */
public class FullJustify {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strings = fullJustify(words, 16);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        //记录当前已加入的最后一个单词的索引+1，所以需要小心索引溢出
        int right = 0;
        int len = words.length;
        while (true) {
            //记录起点索引，因为需要用到从left到right范围的索引
            int left = right;
            //记录当前行的字符串长度(不包含当前行的空格个数长度)
            int sumLen = 0;
            //记录当前行字符串长度，并让right指针自增，right指针要小于words数组长度，并且当前行字符串长度+需要添加单词的长度+空格长度（这里左右指针只差刚好是所需的空格数）
            while (right < len && sumLen + words[right].length() + (right - left) <= maxWidth) {
                sumLen += words[right++].length();
            }

            //最后一行(特征：right指针等于words数组长度)，先将left到right-1的单词相隔一个空格拼接,然后填满空格并将数组返回
            if (right == words.length) {
                StringBuffer sb = join(words, left, right, " ");
                sb.append(blank(maxWidth - sb.length()));
                list.add(sb.toString());
                return list;
            }

            //只有一个单词直接将空格填满,然后跳过本次循环，避免执行后续代码
            if (left + 1 == right) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(sb.length()));
                list.add(sb.toString());
                continue;
            }

            //首先定义right-left为总共有numWords个单词，然后定义需numBlank个空格
            int numWords = right - left;
            int numBlank = maxWidth - sumLen;
            //再定义avgBlank为还需要平均加入的空格数，extendBlank为平均空格数后还需填入的空格数（取余）
            int avgBlank = numBlank / (numWords - 1);
            int extendBlank = numBlank % (numWords - 1);
            //extendBlank的值就是需要拼接多少个avgBlank+1个空格。
            StringBuffer sb = join(words, left, left + extendBlank + 1, blank(avgBlank + 1));
            sb.append(blank(avgBlank));
            sb.append(join(words, left + extendBlank + 1, right, blank(avgBlank)));
            list.add(sb.toString());
        }
    }

    //获取拼接所需的n个空格
    public static String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    //拼接操作，将第left到right-1的单词用指定字符串str进行拼接
    public static StringBuffer join(String[] words, int left, int right, String str) {
        //先将当前行第一个单词加入，因为后面的单词在加入前都要先加空格，规则与第一个单词不一样
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; i++) {
            sb.append(str);
            sb.append(words[i]);
        }
        return sb;
    }
}
