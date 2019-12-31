package com.cyq7on.leetcode.linked_list;

/**
* @description
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
* @author cyq7on
* @create 2019/12/31
**/
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummyNode;
        while (true) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    minIndex = i;
                }
            }

            if (minIndex == -1) {
                break;
            }

            lists[minIndex] = lists[minIndex].next;
            cur.next = new ListNode(min);
            cur = cur.next;

        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode listNode1 = new ListNode(new int[]{1,4,5});
        ListNode listNode2 = new ListNode(new int[]{1,3,4});
        ListNode listNode3 = new ListNode(new int[]{2,6});
        ListNode[] lists = new ListNode[]{listNode1, listNode2, listNode3};
        System.out.println(mergeKSortedLists.mergeKLists(lists));;
    }
}
