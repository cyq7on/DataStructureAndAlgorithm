package com.cyq7on.practice.other;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i][m] = arr[i][0];
        }
        System.out.println(maxSubSum2D(arr, n, m));
    }

    public static int maxSubSum2D(int[][] matrix, int N, int M) {
        int sum = Integer.MIN_VALUE;
        int[][] totalColSum = new int[N][M];// 所有子列的和
        int[] subColSum = new int[M];//子列的和
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0)
                    totalColSum[i][j] = matrix[i][j];
                else
                    totalColSum[i][j] = totalColSum[i - 1][j] + matrix[i][j];
            }
        }

        for (int r = 0; r < N - 1; r++) {
            for (int k = r; k < N; k++) {

                if (r == 1 && k == 3) {
                    System.out.println("");
                }

                //构建子列
                for (int j = 0; j < M; j++) {
                    if (r == k) {
                        subColSum[j] = matrix[r][j];//是求单行的情况
                    } else if (r == 0) {
                        subColSum[j] = totalColSum[k][j];//以0为起始行
                    } else {
                        subColSum[j] = totalColSum[k][j] - totalColSum[r - 1][j];//以非0为起始行，需要减去前面的
                    }

                }

                sum = Math.max(sum, maxSubSum(subColSum));//转为最大子段和

            }
        }

        return sum;

    }

    public static int maxSubSum(int[] a) {
        int maxSum = 0, curSum = 0;
        for (int i = 0; i < a.length; i++) {
            curSum += a[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            } else if (curSum < 0) {
                curSum = 0;
            }
        }

        return maxSum;
    }


    private static TreeNode createTree(String s) {
        String[] arr = s.split(" ");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[i++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (i >= arr.length) {
                break;
            }
            TreeNode node = queue.poll();
            node.left = new TreeNode(Integer.parseInt(arr[i]));
            queue.offer(node.left);
            i++;

            if (i >= arr.length) {
                break;
            }
            node.right = new TreeNode(Integer.parseInt(arr[i]));
            queue.offer(node.right);
            i++;
        }
        return root;
    }


    public static void fun(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(" ");
        if (root.left != null && root.right != null) {
            printLeft(root.left, true, sb);
            printRight(root.right, true, sb);
        } else {
            fun(root.left == null ? root.right : root.left, sb);
        }
    }

    public static void printLeft(TreeNode root, boolean flag, StringBuilder sb) {
        if (root == null) return;
        if (flag || (root.left == null && root.right == null)) {
            sb.append(root.val).append(" ");
        }
        printLeft(root.left, flag, sb);
        printLeft(root.right, flag && (root.left == null), sb);
    }

    public static void printRight(TreeNode root, boolean flag, StringBuilder sb) {
        if (root == null) return;
        printRight(root.left, flag && (root.right == null), sb);
        printRight(root.right, flag, sb);
        if (flag || (root.left == null && root.right == null)) {
            sb.append(root.val).append(" ");
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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

