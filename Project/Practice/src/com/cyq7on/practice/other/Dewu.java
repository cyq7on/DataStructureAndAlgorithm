package com.cyq7on.practice.other;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Dewu {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int findLongest(String A, int n, String B, int m) {
        // write code here
        //dp[i][j]为text1前i个字符和text2前j个字符的lcs
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        ListNode head = new ListNode(0);
        ListNode cur = head;
        int sum = 0, carry = 0;
        while (head1 != null || head2 != null) {
            sum += carry;
            if (head1 != null) {
                sum += head1.val;
            }

            if (head2 != null) {
                sum += head2.val;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            sum = 0;
            if (head1 != null) {
                head1 = head1.next;
            }

            if (head2 != null) {
                head2 = head2.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return reverseList(head.next);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return node;
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.equals("")) {
            return result;
        }
        char[] chars = str.toCharArray();
        Set<String> set = new TreeSet<>();
        permutation(0, chars, set);
        result.addAll(set);
        return result;
    }

    public void permutation(int index, char[] chars, Set<String> set) {
        if(index == chars.length - 1) {
            set.add(new String(chars));
            return;
        }
        for(int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutation(index + 1, chars, set);
            swap(chars, index, i);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[]
            visited, final int[] nums) {
        if (permuteList.size() == nums.length) {
            permutes.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue; // 防止重复
            }
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, permutes, visited, nums);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Dewu dewu = new Dewu();
        System.out.println(dewu.findLongest("1AB2345CD", 9, "12345EF", 7));
    }

}
