package com.cyq7on.leetcode.linklist;

/**
 * @author cyq7on
 * @description Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * @create 2019/12/22
 **/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            return deleteDuplicates(head.next);
        }

        head.next = deleteDuplicates(head.next);
        return head;
    }



    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        System.out.println(removeDuplicatesFromSortedList.deleteDuplicates(new ListNode(new int[]{1,1,2})));
        System.out.println(removeDuplicatesFromSortedList.deleteDuplicates(new ListNode(new int[]{1,1,2,2,3,3})));
    }
}
