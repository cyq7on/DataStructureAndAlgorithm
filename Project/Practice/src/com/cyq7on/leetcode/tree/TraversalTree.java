package com.cyq7on.leetcode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* @description
 * 使用通用的非递归的方式完成二叉树遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 * 我们有一棵二叉树：
 *
 *                中
 *               /  \
 *              左   右
 * 前序遍历：中，左，右
 * 中序遍历：左，中，右
 * 后序遍历：左，右，中
 *
 * 本题需要中序遍历。
 *
 * 栈是一种 先进后出的结构，出栈顺序为左，中，右
 * 那么入栈顺序必须调整为倒序，也就是右，中，左
 *
 * 同理，如果是前序遍历，入栈顺序为 右，左，中；后序遍历，入栈顺序中，右，左
* @author cyq7on
* @create 2020/8/27
**/
public class TraversalTree {
    static class ColorNode {
        public String color;
        public TreeNode root;

        public ColorNode(String color, TreeNode root) {
            this.color = color;
            this.root = root;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<ColorNode> stack = new LinkedList<>();
        stack.add(new ColorNode("w", root));
        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            if (colorNode.color.equals("g")) {
                list.add(colorNode.root.val);
            }else {
                //这里就是三种遍历方式push顺序不一样的地方
                colorNode.color = "g";
                if (colorNode.root.right != null) {
                    stack.push(new ColorNode("w",colorNode.root.right));
                }
                stack.push(colorNode);
                if (colorNode.root.left != null) {
                    stack.push(new ColorNode("w",colorNode.root.left));
                }
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<ColorNode> stack = new LinkedList<>();
        stack.add(new ColorNode("w", root));
        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            if (colorNode.color.equals("g")) {
                list.add(colorNode.root.val);
            }else {
                colorNode.color = "g";
                if (colorNode.root.right != null) {
                    stack.push(new ColorNode("w",colorNode.root.right));
                }
                if (colorNode.root.left != null) {
                    stack.push(new ColorNode("w",colorNode.root.left));
                }
                stack.push(colorNode);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<ColorNode> stack = new LinkedList<>();
        stack.add(new ColorNode("w", root));
        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            if (colorNode.color.equals("g")) {
                list.add(colorNode.root.val);
            }else {
                colorNode.color = "g";
                stack.push(colorNode);
                if (colorNode.root.right != null) {
                    stack.push(new ColorNode("w",colorNode.root.right));
                }
                if (colorNode.root.left != null) {
                    stack.push(new ColorNode("w",colorNode.root.left));
                }
            }
        }
        return list;
    }

}
