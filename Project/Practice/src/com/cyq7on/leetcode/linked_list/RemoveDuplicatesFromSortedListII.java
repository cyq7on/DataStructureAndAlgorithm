package com.cyq7on.leetcode.linked_list;

/**
 * @author cyq7on
 * @description Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 * @create 2019/12/22
 **/
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicates(head, Integer.MAX_VALUE);
    }

    private ListNode deleteDuplicates(ListNode head,int lastVal) {
        if (head == null) {
            return null;
        }

        //头结点值等于上个节点的值，移除头节点，从下个节点开始递归
        if (head.val == lastVal) {
            return deleteDuplicates(head.next, head.val);
        }

        if (head.next == null) {
            return head;
        }

        //头节点的值等于下个节点的值，则移除头结点和下一个节点，从下下个节点开始递归
        if (head.val == head.next.val) {
            return deleteDuplicates(head.next.next,head.val);
        }

        //头结点和下个节点都存在且值不相等，保留头节点，从下个节点开始递归
        head.next = deleteDuplicates(head.next,head.val);
        return head;
    }


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
        System.out.println(removeDuplicatesFromSortedListII.deleteDuplicates(new ListNode(new int[]{-1,0,0,0,0,3,3})));
        System.out.println(removeDuplicatesFromSortedListII.deleteDuplicates(new ListNode(new int[]{1,2,2})));
        System.out.println(removeDuplicatesFromSortedListII.deleteDuplicates(new ListNode(new int[]{1,2,3,3,4,4,5})));
        System.out.println(removeDuplicatesFromSortedListII.deleteDuplicates(new ListNode(new int[]{1,1,1,2,3})));
        System.out.println(removeDuplicatesFromSortedListII.deleteDuplicates(new ListNode(new int[]{1,1,1,2,3,3})));
    }
}
