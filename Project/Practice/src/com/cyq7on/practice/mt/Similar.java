package com.cyq7on.practice.mt;

import java.util.Scanner;

public class Similar {
    public static void main(String[] args) {
//        int[] arr = new int[]{3, 5, 6, 1};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] memo = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                continue;
            }
            for (int j = +1; j < arr.length; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    res[i] = 1;
                    res[j] = 1;
                    break;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                System.out.print(-1);
                System.out.print(" ");
            }else {
                System.out.print(res[i]);
                System.out.print(" ");
            }

        }
    }
}
