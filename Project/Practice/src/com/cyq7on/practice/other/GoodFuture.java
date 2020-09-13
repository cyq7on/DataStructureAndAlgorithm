package com.cyq7on.practice.other;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class GoodFuture {


    public String notReCuPreOrder(TreeNode root) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int count;
        int n = num.length();
        if (n % 2 == 0) {
            count = n / 2 - 1;
        } else {
            /*if (num.matches("^1[01]*00$")) {
                count = n / 2;
            }else {
                count = n / 2 + 1;
            }*/
            count = n / 2 + 1;
        }
        System.out.println(count);

        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(getPosition(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
        }*/
    }

    private static long getPosition(int a, int b, int k) {
        /*long res = (a - b) * (k / 2);
        if (k % 2 != 0) {
            res += a;
        }*/
        BigInteger res = new BigInteger(String.valueOf(a - b)).multiply(new BigInteger(String.valueOf(k / 2)));
        if (k % 2 != 0) {
            res = res.add(new BigInteger(String.valueOf(a)));
        }
        return res.longValue();
    }

}
