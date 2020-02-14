package com.cyq7on.leetcode.linklist;


/**
* @description
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
* @author cyq7on
* @create 2019/12/17
**/
public class ReverseLinkedList {
    //递归
    public ListNode reverseList(ListNode head) {
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

    // 循环
    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null,next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[] {1,2,3,4,5});
        System.out.println(listNode);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(reverseLinkedList.reverseList(listNode));
    }

}
