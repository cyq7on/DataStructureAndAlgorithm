package com.cyq7on.leetcode;

public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1000000));
    }

    public static boolean judgeSquareSum(int c) {
        int low = 0, high = (int) Math.sqrt(c);
        int mul;
        while (low <= high) {
            mul = low * low + high * high;
            if (mul == c) {
                return true;
            } else if (mul < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
}
