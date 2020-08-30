package com.cyq7on.practice.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Amazy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(scanner.nextInt());
            return;
        }

        if (n == 2) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            if (Math.abs(n1 - n2) == 1) {
                System.out.println(Math.max(n1, n2));
            }else {
                System.out.println(n1 + n2);
            }
        }

        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            max = Math.max(max, arr[i]);
        }

        int[] num = new int[max];

        for (int i = 0; i < n; i++) {
            num[arr[i] - 1] += arr[i];
        }

        int[] dp = new int[n+1];
        for (int i = 3; i <= n ; i++) {
//            dp[i] = Math.max()
        }

    }
}
