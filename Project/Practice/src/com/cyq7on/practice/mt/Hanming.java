package com.cyq7on.practice.mt;

import java.util.Scanner;

public class Hanming {
    public static int getHanmingDistance(int num1, int num2) {
        int num = num1 ^ num2;
        int count = 0;
        while (num != 0) {
            if ((num & 1) > 0) {
                count++;
            }
            num >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(getHanmingDistance(11, 6));
//        System.out.println(getHanmingDistance(10000, 9999));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n < 2) {
            System.out.println(0);
            return;
        }
        int max = -1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = getHanmingDistance(arr[i], arr[j]);
                if (distance > max) {
                    max = distance;
                }
            }

        }
        System.out.println(max);
    }
}
