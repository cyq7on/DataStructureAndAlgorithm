package com.cyq7on.practice.tx;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        int high = 0;
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
            high = Math.max(num[i], high);
        }
        System.out.println(getRes(num, high));
    }

    private static int getRes(int[] num, int h) {
        if (h > num.length) {
            return num.length;
        }
        int ans = 0;
        while (h > 0) {
            int index = 0;
            while (index < num.length) {
                while (index < num.length && num[index] != 0) {
                    num[index]--;
                    index++;
                }
                ans++;
                while (index < num.length && num[index] == 0) {
                    index++;
                }
            }
            h--;
        }
        return ans;
    }

}

