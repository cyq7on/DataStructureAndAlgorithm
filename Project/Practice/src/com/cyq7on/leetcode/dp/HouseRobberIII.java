package com.cyq7on.leetcode.dp;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyq7on
 * @description The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * Input: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * @create 2020/1/5
 **/
public class HouseRobberIII {
    public int rob(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        preOder(root, 0, map);
        return robMax(map);
    }

    private void preOder(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        Integer integer = map.get(level);
        if (integer == null) {
            integer = 0;
        }
        integer += root.val;
        map.put(level, integer);
        preOder(root.left, level + 1, map);
        preOder(root.right, level + 1, map);
    }

    // from HouseRobber
    private int robMax(Map<Integer,Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        if (nums.size() == 1) {
            return nums.get(0);
        }
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < nums.size(); i++) {
            dp[i] = Math.max(dp[i - 2] + nums.get(i), dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
       /* TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(1);*/
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        System.out.println(houseRobberIII.rob(root));
    }
}
