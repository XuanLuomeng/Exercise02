package week15.day3;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 快乐数
 * @date 2025/9/22 19:32
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 思路：
 * 快慢指针
 * 慢指针求自己的下一次结果，快指针求自己的下两次结果。
 * 如果有循环，快慢指针的结果最终至少会重叠一次。
 */
public class IsHappy {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        } while (fast != 1 && fast != slow);
        return fast == 1;
    }

    public static int getSum(int n) {
        String str = String.valueOf(n);
        char[] charArray = str.toCharArray();
        int result = 0;
        for (char c : charArray) {
            result += (c - '0') * (c - '0');
        }
        return result;
    }
}
