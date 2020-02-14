package com.cyq7on.sword2offer;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        Integer rootIndex = inorderMap.get(rootVal);
        int num = rootIndex - inStart;
//        int leftPreEnd = preStart + 1 + num;
        //这里不加1才是对的，我这里取的end是闭区间
        int leftPreEnd = preStart + num;
        root.left = buildTree(preorder, preStart + 1, leftPreEnd, inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, leftPreEnd + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
    }
}
