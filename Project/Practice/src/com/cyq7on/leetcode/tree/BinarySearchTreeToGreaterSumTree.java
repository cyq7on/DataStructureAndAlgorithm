package com.cyq7on.leetcode.tree;

/**
 * @author cyq7on
 * @description Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * @create 2019/12/24
 **/
public class BinarySearchTreeToGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        int sum = preOrderSum(root);
        inOrder(root, sum);
        return root;
    }

    private int preOrderSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + preOrderSum(root.left) + preOrderSum(root.right);
    }

    private int inOrder(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = inOrder(root.left, sum);
        int val = root.val;
        root.val = sum;
        sum -= val;
        return inOrder(root.right, sum);
    }
}
