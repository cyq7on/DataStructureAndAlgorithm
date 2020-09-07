package com.cyq7on.leetcode.linklist;

/**
 * @author cyq7on
 * @description 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/9/5
 **/
public class ReverseKGroup {
    public ListNode reverseKGroupByRecur(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int i;
        for (i = 1; i <= k; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }

        ListNode node = reverse(head, cur);
        head.next = reverseKGroupByRecur(cur.next,k);

        return node;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head == tail || head.next == null) {
            return head;
        }

        ListNode node = reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode end = pre.next;

        int count = 1;
        while (end != null) {
            end = end.next;
            count++;
            if (count % k == 0 && end != null) {
                ListNode next = end.next;
                ListNode cur = pre.next;
                end.next = null;
                reverse(cur);

                //pre接上翻转前的尾结点
                pre.next = end;
                //cur翻转后变为尾结点，接上后续的next
                cur.next = next;
                //pre是下次需要翻转的头结点的上个节点
                pre = cur;
                end = cur;
            }
        }

        return dummyNode.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
//        System.out.println(reverseKGroup.reverse(head,head.next.next.next.next));
        System.out.println(reverseKGroup.reverse(head.next,head.next.next.next));
        System.out.println(reverseKGroup.reverseKGroup(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(reverseKGroup.reverseKGroupByRecur(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
