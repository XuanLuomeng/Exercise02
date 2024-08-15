package week13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/15 17:29
 * <p>
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 */
public class FindSubstring {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        List<Integer> substring = findSubstring(s, words);
        for (Integer i : substring) {
            System.out.println(i);
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int len = words.length;
        List<Integer> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        int stringLen = words[0].length();
        int stringMaxLec = stringLen * len;
        int left = 0;

        while (left - 1 < s.length() - stringMaxLec) {
            HashMap<String, Integer> tempMap = new HashMap<>();
            int mapLen = 0;
            while (mapLen < len) {
                String sub = s.substring(left + mapLen * stringLen, left + (mapLen + 1) * stringLen);
                if (map.containsKey(sub)) {
                    int index = tempMap.getOrDefault(sub, 0);
                    tempMap.put(sub, index + 1);
                    if (map.get(sub) < tempMap.get(sub)) {
                        break;
                    }
                } else {
                    break;
                }
                mapLen++;
            }
            if (mapLen == len) {
                res.add(left);
            }
            left++;
        }
        return res;
    }
}
