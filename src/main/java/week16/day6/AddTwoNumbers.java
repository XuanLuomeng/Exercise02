package week16.day6;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 两数相加
 * @date 2025/10/2 21:37
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;

        while (cur1 != null || cur2 != null) {

            int sum = carry;

            if (cur1 != null) {
                sum += cur1.val;
                cur1 = cur1.next;
            }

            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }

            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
