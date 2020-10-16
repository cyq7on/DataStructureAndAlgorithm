package com.cyq7on.practice.other;

import com.cyq7on.leetcode.linklist.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HengSheng {
    public static void main(String[] args) {
        System.out.println(getMidNode(new ListNode(new int[]{1,2,3})));
        System.out.println(getMidNode(new ListNode(new int[]{1,2,3,4})));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            int count = map.getOrDefault(ch, 0);
            count++;
            map.put(ch, count);
        }

        int first = 0,second = 0;
        char res = '0',temp = '0';
        for (char ch : chars) {
            int count = map.get(ch);
            if (count > first) {
                second = first;
                res = temp;
                first = count;
                temp = ch;
            } else if (count > second && count != first) {
                second = count;
                res = ch;
            }
        }
        if (first == second) {
            System.out.println("null");
        }else {
            System.out.println(res == '0' ? "null" : res);
        }

    }

    public static ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
