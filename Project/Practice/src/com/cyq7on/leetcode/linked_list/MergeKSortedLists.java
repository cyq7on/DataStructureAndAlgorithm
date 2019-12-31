package com.cyq7on.leetcode.linked_list;

/**
 * @author cyq7on
 * @description Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * @create 2019/12/31
 **/
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int length = lists.length;
        int right = length % 2 == 0 ? length : length - 1;
        ListNode[] newLists = new ListNode[length / 2 + length % 2];
        int i = 0;
        for (; i < right / 2; i++) {
            newLists[i] = mergeTwoLists(lists[i],lists[right - 1 - i]);
        }
        if (right != length) {
            newLists[i] = lists[length - 1];
        }
        return mergeKLists(newLists);
    }

    /**
     * Runtime: 125 ms, faster than 13.92% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 57.2 MB, less than 5.47% of Java online submissions for Merge k Sorted Lists.
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }
        ListNode merge = lists[0];
        for (int i = 1; i < length; i++) {
            merge = mergeTwoLists(merge,lists[i]);
        }
        return merge;
    }

    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                cur.next = listNode1;
                listNode1 = listNode1.next;
            }else {
                cur.next = listNode2;
                listNode2 = listNode2.next;
            }
            cur = cur.next;
        }

        if (listNode1 == null) {
            cur.next = listNode2;
        }else {
            cur.next = listNode1;
        }

        return dummyNode.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
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

            cur.next = lists[minIndex];
            cur = cur.next;

            lists[minIndex] = lists[minIndex].next;
        }
        return dummyNode.next;
    }


    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        /*ListNode listNode1 = new ListNode(new int[]{1, 4, 5});
        ListNode listNode2 = new ListNode(new int[]{1, 3, 4});
        ListNode listNode3 = new ListNode(new int[]{2, 6});
        ListNode[] lists = new ListNode[]{listNode1, listNode2, listNode3};*/

        ListNode listNode2 = new ListNode(new int[]{-1, 5, 11});
        ListNode listNode4 = new ListNode(new int[]{6,10});
        ListNode[] lists = new ListNode[]{null, listNode2, null,listNode4};
        System.out.println(mergeKSortedLists.mergeKLists(lists));
    }
}
