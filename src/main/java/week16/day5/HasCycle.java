package week16.day5;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 环形链表
 * @date 2025/10/1 19:19
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 循环问题解决思路:判断循环的最佳方式是快慢指针,慢指针转一圈后，快指针追上慢指针，则说明有环。
 */
public class HasCycle {
    public static void main(String[] args) {
        System.out.println(hasCycle(new ListNode(1)));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
