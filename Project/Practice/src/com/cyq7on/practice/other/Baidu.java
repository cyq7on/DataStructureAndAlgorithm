package com.cyq7on.practice.other;

import java.util.*;

public class Baidu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long base = (long) (1e9 + 7);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(climbStairs(n, m) % base);
        /*int val = 0, sum = 0, countZero = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            sum += num;
            if (num == 0) {
                countZero++;
            }
            if (sum % 9 == 0) {
                val = sum;
            }
        }
        if (val > 0 && countZero > 0) {
            int k = val / 5;
            for (int i = 0; i < k; i++){
                System.out.print("5");
            }
            for (int i = 0; i < countZero; i++){
                System.out.print("0");
            }
        } else if (countZero > 0) {
            System.out.println("0");
        } else System.out.println("-1");*/
    }

    private static int climbStairs(int n, int m) {
        int[] dp = new int[n + 1];
        int[] steps = new int[m];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            steps[i] = i + 1;
        }
//        Set<Integer> set = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
//            dp[i] = 0;
            for (int j = 0; j < m; j++) {
                int step = steps[j];
                if (i < step || deque.contains(step)) {
                    continue;
                }
                deque.addLast(step);
                if (deque.size() >= 3) {
                    deque.pollFirst();
                }
                dp[i] = dp[i] + dp[i - step];
            }
        }
        return dp[n];

    }

}
