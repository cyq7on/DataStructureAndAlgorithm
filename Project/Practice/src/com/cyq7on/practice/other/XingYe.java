package com.cyq7on.practice.other;

import java.util.Scanner;

public class XingYe {
    public static void main(String[] args) {
        int sum = 20, n = 3;
        while (n >> 1 < 9) {
            sum = sum - n;
            n++;
        }
        System.out.println(n);
        System.out.println(sum);
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        if (split.length != 2) {
            System.out.println("ERROR");
//            System.out.println("输入非法");
            return;
        }
        try {
            int a = Integer.valueOf(split[0]);
            int b = Integer.valueOf(split[1]);
            if (a > b) {
                System.out.println("ERROR");
//            System.out.println("输入非法");
                return;
            }
            long min = Math.min(a, b);
            long max = Math.max(a, b);
            StringBuilder sb = new StringBuilder();
            for (long i = min; i <= max; i++) {
                if (isPrime(i)) {
                    sb.append(i).append(",");
                }
            }
            if (sb.length() == 0) {
                System.out.println("NO DATA");
//            System.out.println("区间内无素数");
                return;
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }

    private static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }
}
