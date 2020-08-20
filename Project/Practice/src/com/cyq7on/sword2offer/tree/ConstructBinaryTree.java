package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int preRootIndex, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preRootIndex]);
        int inRootIndex = inorderMap.get(preorder[preRootIndex]);
        root.left = buildTree(preRootIndex + 1, inLeft, inRootIndex - 1);
        root.right = buildTree(preRootIndex + (inRootIndex - inLeft + 1), inRootIndex + 1, inRight);
        return root;
    }


    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
    }
}
