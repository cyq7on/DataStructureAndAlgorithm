package com.cyq7on.practice.other;

import com.cyq7on.leetcode.linklist.ListNode;

import java.util.Arrays;

/**
* @description
 * [1,3,5,4,7]
 *
 * 1,3,5
* @author cyq7on
* @create 2020/9/4
**/
public class Bigo {

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1});
        System.out.println(reverse(node));

        System.out.println(Arrays.toString(findSeq(new int[]{1,3,5,4,7})));

        String s1 = new String("test");
        String s2 = s1.intern();
        String s3 = "test";
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
        System.out.println(s3 == s1);

        Integer i1 = new Integer(40);
        Integer i2 = new Integer(40);
        Integer i3 = new Integer(0);

        System.out.println(i1 == i2);
        System.out.println(i1 + i3 == i2);
        System.out.println(i1 + i3 == i1);
        System.out.println(40 == i1);
    }

    public static int[] findSeq(int[] nums) {
        int start = 0;
        int len = 1;
        int[] res = new int[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                len++;
            }else {
                if (len > res.length) {
                    res = Arrays.copyOfRange(nums, start, i);
                }
                start = i;
                len = 1;
            }
        }
        return res;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return node;
    }

}
