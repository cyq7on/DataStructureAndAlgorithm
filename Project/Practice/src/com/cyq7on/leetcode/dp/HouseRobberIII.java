package com.cyq7on.leetcode.dp;

import com.cyq7on.leetcode.tree.TreeNode;

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
        Map<Object, Object> map = new HashMap<>();
        preOder(root, 0, new HashMap<>());
        System.out.println(map);
        return 0;
    }

    private void preOder(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        Integer integer = map.get(level);
        if (integer == null) {
            integer = 0;
        }
        integer++;
        map.put(level, integer);
        preOder(root.left, level + 1, map);
        preOder(root.right, level + 1, map);
    }
}
