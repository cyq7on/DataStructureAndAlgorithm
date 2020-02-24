package com.cyq7on.leetcode.linklist;

/**
 * @author cyq7on
 * @description 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2019/12/31
 **/
public class MergeTwoSortedLists {

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

    public ListNode mergeTwoListsByRecursive(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }

        if (listNode2 == null) {
            return listNode1;
        }

        if (listNode1.val < listNode2.val) {
            listNode1.next = mergeTwoLists(listNode1.next, listNode2);
            return listNode1;
        }else {
            listNode2.next = mergeTwoLists(listNode1,listNode2.next);
            return listNode2;
        }
    }


    public static void main(String[] args) {
        MergeTwoSortedLists mergeKSortedLists = new MergeTwoSortedLists();

        ListNode listNode1 = new ListNode(new int[]{1, 2, 4});
        ListNode listNode2 = new ListNode(new int[]{1, 3, 4});

//        System.out.println(mergeKSortedLists.mergeTwoLists(listNode1,listNode2));
        System.out.println(mergeKSortedLists.mergeTwoListsByRecursive(listNode1,listNode2));
    }
}
