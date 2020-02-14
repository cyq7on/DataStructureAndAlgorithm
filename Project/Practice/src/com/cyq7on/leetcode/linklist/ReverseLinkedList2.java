package com.cyq7on.leetcode.linklist;


/**
 * @author cyq7on
 * @description Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * @create 2019/12/17
 **/
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        ListNode left, right = null;
        int index = 0;
        while (index < m - 1) {
            cur = cur.next;
            index++;
        }

        // 第一段不需要翻转的最后一个节点
        left = cur;
        // 需要翻转的链表头
        head = cur.next;

        while (index < n) {
            cur = cur.next;
            index++;
        }

        if (cur != null) {
            // 第二段不需要翻转的第一个节点
            right = cur.next;
            // 截取出需要翻转的链表
            cur.next = null;
        }

        // 翻转要求的区间的链表，并将其头作为left的下一个节点
        left.next = reverseList(head);
        // 翻转前的头成了尾，其下一个节点是right
        head.next = right;

        // 返回虚拟节点的下一个节点
        return dummyNode.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        // head.next是逆转后的最后一个元素
        head.next.next = head;
        // 最后一个元素的next为null
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(listNode);
        ReverseLinkedList2 reverseLinkedList = new ReverseLinkedList2();
        System.out.println(reverseLinkedList.reverseBetween(listNode, 2, 4));

        /*ListNode listNode = new ListNode(new int[]{3,5});
        System.out.println(listNode);
        ReverseLinkedList2 reverseLinkedList = new ReverseLinkedList2();
        System.out.println(reverseLinkedList.reverseBetween(listNode, 1, 2));*/

        /*ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(listNode);
        ReverseLinkedList2 reverseLinkedList = new ReverseLinkedList2();
        System.out.println(reverseLinkedList.reverseBetween(listNode, 3, 4));*/
    }

}
