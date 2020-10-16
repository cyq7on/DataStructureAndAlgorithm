package com.cyq7on.practice.other;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class WeiLai {

    private int val;
    private TreeNode b;
    //层序遍历反序列化
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i >= split.length) {
                break;
            }
            if (!split[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.left);

                if (node.left.val == 5) {
                    b = node.left;
                }
            }
            i++;
            if (i >= split.length) {
                break;
            }
            if (!split[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.right);
                if (node.right.val == 5) {
                    b = node.left;
                }
            }
            i++;
        }
        return root;
    }



    public static void main(String[] args) {
        String data = "0,5,10,7,2,null,3";
        WeiLai weiLai = new WeiLai();
        TreeNode root = weiLai.deserialize(data);
        weiLai.preOrder(root,root,weiLai.b);
        System.out.println(weiLai.val);
    }

    public void preOrder(TreeNode root, TreeNode p,TreeNode q) {
        if (root == null) {
            return;
        }
        val += root.val;

        if (root == p || root == q) {
            return;
        }
        preOrder(root.left,p,q);
        preOrder(root.right,p,q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }
}
