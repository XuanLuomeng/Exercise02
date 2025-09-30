package week16;

import java.util.Stack;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 基本计算器
 * @date 2025/9/30 20:39
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 * 提示：
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 */
public class CalculatePlus {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }

    /**
     * 堆栈思路:
     * 1、清理字符串中的空格
     * 2、创建两个栈，一个栈存储数字，一个栈存储操作符
     * 3、数字栈先加入一个0，避免负数运算时出栈没有数字可以计算
     * 4、遍历字符串
     * 5、'('直接入栈，')'将栈内的数字和操作符全部出栈进行计算，并把结果入栈
     * 6、数字需要判断是否是数字，如果是数字则需要判断是否是多位数，最后将数字结果入栈
     * 7、操作符入栈时，假如栈内已有非括号操作符，则将栈内操作符进行计算，并把结果入栈，最后将操作符入栈
     * @param s
     * @return
     */
    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = ch[i];
            if (c == '(') {
                opStack.push(c);
            }else if (c == ')') {
                // 栈内括号出栈进行计算
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    cal(numStack, opStack);
                }
                // 左括号出栈
                opStack.pop();
            } else if (Character.isDigit(c)) {
                int num = 0;
                // 判断是否是多位数
                while (i < s.length() && Character.isDigit(ch[i])) {
                    num = num * 10 + (ch[i++] - '0');
                }
                // 数字入栈，i--回退一位
                numStack.push(num);
                i--;
            } else {
                // 排除一元运算符
                if (c == '-' && (i == 0 || ch[i-1] == '(')){
                    numStack.push(0);
                }
                // 栈内非括号操作符出栈进行计算
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    cal(numStack, opStack);
                }
                // 操作符入栈
                opStack.push(c);
            }
        }

        while (!opStack.isEmpty()){
            // 将剩余的操作符进行计算，并把结果入栈
            cal(numStack, opStack);
        }

        return numStack.peek();
    }

    public static void cal(Stack<Integer> numStack ,Stack<Character> opStack){
        // 判断栈内元素是否满足计算条件
        if (numStack.isEmpty() || numStack.size() < 2 || opStack.isEmpty()) {
            return;
        }

        // 计算栈内元素，注意减号时，先弹出的数字是被减数
        int num1 = numStack.pop();
        int num2 = numStack.pop();
        char op = opStack.pop();
        numStack.push( op == '+' ? num1 + num2 : num2 - num1);
    }

    /**
     * 递归思路:
     * 1、删除空格
     * 2、遍历每个字符
     * 3、遇到括号则递归计算括号内的结果
     * 4、遇到符号，通过符号判断sign是 -1 还是 1
     * 5、遇到数字则判断是否是多位数，获取数字结果；获取数字结果后，* sign
     * 6、将数字结果 += 到 result 中。
     */
}
