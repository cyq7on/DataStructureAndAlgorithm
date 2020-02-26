package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    private List<List<Integer>> paths = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return paths;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                paths.add(new ArrayList<>(list));
            }
        }
        if (root.left != null) {
            pathSum(root.left, sum);
        }
        if (root.right != null) {
            pathSum(root.right, sum);
        }
        list.remove(list.size() - 1);
        return paths;
    }

}
