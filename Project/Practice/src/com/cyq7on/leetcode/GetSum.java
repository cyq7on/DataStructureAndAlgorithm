package com.cyq7on.leetcode;

public class GetSum {
    public static void main(String[] args) {
        System.out.println(getSum(-1, 1));
    }

    public static int getSum(int a, int b) {
        int x, y;
        x = a & b;
        y = a ^ b;
        return x == 0 ? y : getSum(x << 1, y);

    }

    private static int PosSum(int a, int b) {
        int sum;
        while (b > 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }
}
