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
        int len = words.length;
        int length = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            int iLength = words[i].length();
            String word = words[i];
            if ((length % maxWidth) + iLength + 1 < maxWidth) {
                //若当前行还可以放下一个空格+单词，则加入并将长度加到length当中
                if (list.size() == index + 1) {
                    list.set(index, list.get(index) + " " + word);
                    length += iLength + 1;
                } else {
                    list.add(index, word);
                    length += iLength;
                }
            } else {
                //当前行无法放下一个空格+单词
                //先将当前行的内容左右对齐
                //当前行字符串
                String string = list.get(index);
                //当前行字符串长度
                int beforeLength = string.length();
                //所需要的空格长度
                int needBlank = maxWidth - beforeLength;
                //已有的空格个数
                int blankNum = string.split(" ").length - 1;
                //先将所有空格平均放入(非完全平均，即忽视小数点)
                String blank = " ";
                if (blankNum != 0) {
                    for (int j = 0; j < needBlank / blankNum; j++) {
                        blank += " ";
                    }
                    string = string.replaceAll(" ", blank);
                    //如果无妨完全平均放入，则多出来的空格替换第一个识别到的平均空格为平均空格+1
                    int extendBlank = needBlank % blankNum;
                    if (extendBlank != 0) {
                        String signBlank = blank + " ";
                        String[] strs = string.split(blank);
                        int j = 0;
                        string = strs[0];
                        for (int k = 1; k < strs.length; k++) {
                            if (j < extendBlank) {
                                string += signBlank + strs[k];
                                j++;
                            }else {
                                string += blank + strs[k];
                            }
                        }
                    }
                } else {
                    //一个单词占满了一行，则将末尾空格补齐
                    for (int j = 0; j <= maxWidth - list.get(index).length(); j++) {
                        string += " ";
                    }
                }

                list.set(index, string);

                //转入下一行并长度清空
                length = 0;
                index++;

                list.add(index, word);
                length += iLength;
            }
        }
        //最后一行把空格补满
        String endString = list.get(index);
        for (int i = 0; i < maxWidth - list.get(index).length(); i++) {
            endString += " ";
        }
        list.set(index, endString);
        return list;
    }
}
