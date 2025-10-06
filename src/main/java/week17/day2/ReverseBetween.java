package week17.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 反转指定区间链表
 * @date 2025/10/6 21:03
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        ListNode res = reverseBetween(head, 1, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 本方法采用遍历一次遍历链表，将需要反转的区间节点保存在list中
     * 然后倒序处理list中的所有节点，最后将left之前的节点连接上反转后的节点
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode nowNode = head;
        int index = 1;

        // 找到 left 节点的前一个节点,并将需要反转的区间节点保存在list中
        List<ListNode> list = new ArrayList<>();
        while (index <= right) {
            if (index < left) {
                pre = nowNode;
            } else {
                list.add(nowNode);
            }
            nowNode = nowNode.next;
            index++;
        }

        // 后面采用倒序反转 list 中的所有节点
        // 但是 left 节点会和 list 中的第二个节点产生循环链表，需要提前处理第一个节点指向 right 节点的下一个节点
        if (list.size() > 1) {
            list.get(0).next = list.get(list.size() - 1).next;
        }

        // 倒序处理所有节点的子节点
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }

        // 将 left 之前的节点连接上反转后的节点，需要排除 left == head 的情况
        if (pre != null) {
            pre.next = list.get(list.size() - 1);
        } else {
            head = list.get(list.size() - 1);
        }

        return head;
    }
}
