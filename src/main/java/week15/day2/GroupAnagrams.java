package week15.day2;

import java.util.*;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 字母异位词分组
 * @date 2025/9/21 20:54
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 提示：
 * strs[i] 仅包含小写字母
 *
 * 思路：
 * 字母异位词经过Arrays.sort()排序后，相同字母异位词的排序结果相同。
 * 以此，将字符串排序后，相同字母异位词的排序结果作为键，从而实现分组。
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return null;
        }

        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key = new String(charArray);
            List<String> list = result.getOrDefault(key, new ArrayList<>());
            list.add(str);

            result.put(key, list);
        }

        return new ArrayList<>(result.values());
    }
}
