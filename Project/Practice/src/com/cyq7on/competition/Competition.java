package com.cyq7on.competition;

import com.cyq7on.leetcode.linklist.ListNode;
import com.cyq7on.leetcode.tree.TreeNode;

import java.util.*;

public class Competition {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] copy = Arrays.copyOf(nums, length);
        Arrays.sort(copy);
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int j = 0;
            while (num > copy[j]) {
                j++;
            }
            res[i] = j;
        }
        return res;
    }

//    public String rankTeams(String[] votes) {
//        Map<Character,Integer> map = new HashMap<>();
//        String vote = votes[0];
//        for (int i = 0; i < vote.length(); i++) {
//            map.put(vote.charAt(i), i);
//        }
//
//        for (int i = 1; i < votes.length; i++) {
//            for (int j = 0; j < votes[i].length(); j++) {
//                Character character = votes[i].charAt(j);
//                Integer integer = map.get(character);
//                map.put(character, integer + j);
//            }
//        }
//
//        Collection<Integer> values = map.values();
//        List<Character> list = new ArrayList<>(3);
//        for(Integer integer : values) {
//            if (map.get)
//        }
//    }

    private int size;
    private boolean res = false;

    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode cur = head;
        size = 1;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }
        backTrack(head,root,new LinkedList<>());
        return res;
    }

    private void backTrack(ListNode head, TreeNode root, LinkedList<ListNode> track) {
        if (track.size() == size) {
            res =  true;
            return;
        }
        if (root == null) {
            res = true;
            return;
        }
        if (head == null) {
            return;
        }
        if (root.val == head.val) {
            track.add(head);
            backTrack(head.next,root.left,track);
            backTrack(head.next,root.right,track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Competition competition = new Competition();
        System.out.println(Arrays.toString(competition.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(competition.smallerNumbersThanCurrent(new int[]{6,5,4,8})));
        System.out.println(Arrays.toString(competition.smallerNumbersThanCurrent(new int[]{7,7,7,7})));
    }
}
