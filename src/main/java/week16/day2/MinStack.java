package week16.day2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 最小栈
 * @date 2025/9/28 16:17
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * 思路1:
 * 1、 创建两个栈，一个栈用于存储数据，一个栈用于存储最小值
 * 2、 每次push时，将数据入栈，同时判断当前数据是否小于最小值，如果是，则将当前数据入最小栈
 * 3、 每次pop时，判断当前弹出的元素是否等于最小值，如果是，则将栈和最小栈的栈顶元素一起弹出
 * 4、 top() 返回栈的栈顶元素
 * 5、 getMin() 返回最小栈的栈顶元素
 *
 * 思路2:
 * 1、创建一个栈，栈内存储二元数组，第一个元素为数据，第二个元素为栈内的最小值
 * 2、每次push时，数据入栈前判断当前数据是否小于栈顶元素中的最小值，如果是，则保持当前栈顶元素的最小值入栈；否则将自己作为最小值入栈
 * 3、pop时，将栈顶元素弹出
 * 4、top() 返回栈顶元素
 * 5、getMin() 获取栈顶元素携带的最小值
 */
public class MinStack {

    private static Stack<Integer> stack;
    private static Stack<Integer> minStack;

    public static void main(String[] args) {
        minStack();
        push(-2);
        push(0);
        push(-3);
        System.out.println(getMin());
        pop();
        System.out.println(top());
        System.out.println(getMin());
    }

    public static void minStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public static void pop() {
        // 栈为空,最小栈也为空，此时不能进行pop操作
        if (stack.isEmpty() || minStack.isEmpty()) {
            return;
        }
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public static int top() {
        // 栈为空，返回-1
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public static int getMin() {
        // 栈为空，返回-1
        return minStack.isEmpty() ? -1 :minStack.peek();
    }
}
