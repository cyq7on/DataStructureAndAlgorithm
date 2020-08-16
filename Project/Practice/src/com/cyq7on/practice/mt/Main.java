package com.cyq7on.practice.mt;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = scanner.nextInt() % m;
            }
        }
        Arrays.sort(arr);
        int max = arr[n - 1];
        int i = 0;
        while (arr[i] == 0) {
            i++;
        }
        //后面组合计算max
        System.out.println(max);
    }


}




