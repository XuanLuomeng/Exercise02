package week16.day7;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 合并有序链表
 * @date 2025/10/3 22:33
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }

        while (list1 != null){
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }

        while (list2 != null){
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
