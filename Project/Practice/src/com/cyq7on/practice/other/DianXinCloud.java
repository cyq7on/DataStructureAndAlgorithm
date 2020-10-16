package com.cyq7on.practice.other;

import java.util.Scanner;

public class DianXinCloud {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt());
    }

    public static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public static String delStr(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] counts = new int[252];
        int min = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c]++;
        }

        for (char c : chars) {
            min = Math.min(min, counts[c]);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (counts[c] > min) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
