package com.cyq7on.leetcode.linked_list;


/**
 * @author cyq7on
 * @description You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @create 2019/12/18
 **/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (cur1 != null || cur2 != null || sum != 0) {
            if (cur1 != null) {
                sum += cur1.val;
                cur1 = cur1.next;
            }

            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }

        return dummyNode.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int extra = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode pre1 = null, pre2 = null;
        int sum = 0;
        while (cur1 != null && cur2 != null) {
            sum = cur1.val + cur2.val + extra;
            int num = sum;
            if (sum > 9) {
                num = sum % 10;
            }
            cur1.val = num;
            cur2.val = num;

            extra = sum / 10;

            pre1 = cur1;
            pre2 = cur2;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        ListNode target, cur, pre;
        if (cur1 == null) {
            target = l2;
            cur = cur2;
            pre = pre2;
        } else {
            target = l1;
            cur = cur1;
            pre = pre1;
        }
        if (sum < 10) {
            return target;
        }
        while (sum > 9) {
            if (cur == null) {
                cur = new ListNode(0);
                pre.next = cur;
            }
            sum = cur.val + extra;
            int num = sum;
            if (sum > 9) {
                num = sum % 10;
            }
            cur.val = num;
            extra = sum / 10;
            pre = cur;
            cur = cur.next;
        }
        return target;
    }


    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(new int[]{3, 7}), new ListNode(new int[]{9, 2})));
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4})));
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(new int[]{9, 8}), new ListNode(new int[]{1})));
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(new int[]{5}), new ListNode(new int[]{5})));
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(new int[]{1}), new ListNode(new int[]{9, 9})));
    }
}
