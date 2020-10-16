package com.cyq7on.practice.other;

import java.util.Scanner;

public class Ebay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] nums = new int[n];
        for (int i = 0; i < m; i++) {
            int j1 = scanner.nextInt();
            int j2 = scanner.nextInt();
            int val = scanner.nextInt();
            for (int j = j1 - 1; j < j2; j++) {
                nums[j] += val;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
