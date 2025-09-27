package week16.day1;

import java.util.*;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 有效括号
 * @date 2025/9/27 21:01
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class IsValid {
    public static void main(String[] args) {
        String str = "()";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        int len = s.length();
        // 长度为奇数，则必不成立
        if (len % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        // 用Deque双端队列
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
