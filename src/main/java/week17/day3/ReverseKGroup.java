package week17.day3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description k个一组翻转链表
 * @date 2025/10/7 20:14
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        ListNode res = reverseKGroup(head, 2);
        ListNode res = reverseKGroupTwo(head, 2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 直接在链表原地翻转
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroupTwo(ListNode head, int k) {
        // 创建一个临时节点，将临时节点的next指向head
        ListNode temp = new ListNode();
        temp.next = head;

        // 创建两个指针，pre和end指向临时节点
        ListNode pre = temp;
        ListNode end = temp;

        while (end.next != null) {
            // 找到下一个需要翻转的区间起始节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                return temp.next;
            }

            ListNode start = pre.next;
            ListNode next = end.next;

            // 截断链表，断开区间的子节点
            end.next = null;
            // 翻转 (pre, end] 区间，并将反转结果链接到 pre 之后
            pre.next = reverse(start);

            // 拼接链表
            start.next = next;

            // 移动区间
            pre = start;
            end = start;
        }

        return temp.next;
    }

    public static ListNode reverse(ListNode head) {
        // 翻转操作必须保住有两个以上的节点
        if (head == null || head.next == null) {
            return head;
        }
        // 递归翻转
        ListNode temp = reverse(head.next);
        // 两两翻转操作，令前一个节点指向当前节点，当前节点指向null
        // 后面的节点因为两两递归原因，最终只有第一个节点指向为空，其他节点均指向前一个节点
        head.next.next = head;
        head.next = null;
        return temp;
    }

    /**
     * 用数组保存链表节点，然后倒序处理数组中的节点(因为需要先遍历一次链表将节点保存到数组中，耗时较长)
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode nowNode = head;

        // 遍历链表，将所有节点保存在list中
        while (nowNode != null) {
            list.add(nowNode);
            nowNode = nowNode.next;
        }

        for (int i = 0; i < list.size(); i += k) {
            if (i + k <= list.size()) {
                for (int j = 0; j < k / 2; j++) {
                    ListNode temp = list.get(i + j);
                    list.set(i + j, list.get(i + k - 1 - j));
                    list.set(i + k - 1 - j, temp);
                }
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        list.get(list.size() - 1).next = null;

        return list.get(0);
    }
}
