package com.cyq7on.practice.other;

import java.util.LinkedList;

public class GoodFuture {

    public String notReCuPreOrder (TreeNode root) {
        // write code here
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(",");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

}
