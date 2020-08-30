package com.cyq7on.practice.other;

import java.util.*;

public class Tree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String s = scanner.nextLine();
        TreeNode root = deserializeTree(s);
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int[] res = new int[list.size()];

        for (int i = 1; i < res.length - 1; i++) {
            res[i] = list.get(i - 1) + list.get(i + 1);
        }
        res[0] = list.get(1);
        res[res.length - 1] = list.get(res.length - 2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    private static TreeNode deserializeTree(String str) {
        if(str.length() == 0) {
            return null;
        }

        String[] arr = str.split(" ");

        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[i++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            if (i >= arr.length) {
                break;
            }
            TreeNode node = queue.poll();
            if(!arr[i].equals("-1")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.left);
            }
            i++;
            if (i >= arr.length) {
                break;
            }
            if(!arr[i].equals("-1")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
