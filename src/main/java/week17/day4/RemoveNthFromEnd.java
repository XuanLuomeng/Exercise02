package week17.day4;

import java.util.List;
import java.util.ArrayList;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 删除链表的倒数第N个节点
 * @date 2025/10/8 19:42
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = removeNthFromEnd(head, 2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 双指针: 快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndTwo(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode slow = pre;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return pre.next;
    }

    /**
     * 思路:用链表、队列或栈存储链表，然后根据题目要求删除倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        if (list.size() == n && n == 1) {
            return null;
        } else if (list.size() == n) {
            return list.get(1);
        } else if (list.size() > n) {
            ListNode pre = list.get(list.size() - n - 1);
            pre.next = list.get(list.size() - n).next;
            return list.get(0);
        } else {
            return null;
        }
    }
}
