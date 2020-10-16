package com.cyq7on.practice.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JinshanCloud {
    static int index;
    static TreeNode a;
    static TreeNode b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> fib = fibTra(scanner.nextInt());
        for (List<Integer> list : fib) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> fib(int n) {
        List<Integer> list = new ArrayList<>(n * 2);
        list.add(1);
        if (n == 1) {
            return list;
        }
        list.add(1);
        if (n == 2) {
            return list;
        }
        for (int i = 2; i < n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list;
    }

    private static List<List<Integer>> fibTra(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = fib(i);
            for (int j = list.size() - 2; j >= 0; j--) {
                list.add(list.get(j));
            }
            result.add(list);
        }
        return result;
    }

    public static TreeNode buildTree(int[] nums, int numA, int numB) {
        if (index == nums.length) {
            return null;
        }
        if (nums[index] == -1) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(nums[index++]);
        if (node.val == numA) {
            a = node;
        }
        if (node.val == numB) {
            b = node;
        }
        node.left = buildTree(nums, numA, numB);
        node.right = buildTree(nums, numA, numB);
        return node;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
