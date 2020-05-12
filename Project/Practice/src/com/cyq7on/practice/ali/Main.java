package com.cyq7on.practice.ali;

import java.util.Scanner;

public class Main {
    public static void getFruit(int n, int m, int[] arr) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= m) {
                count++;
            }else {
                sum += arr[i];
            }
        }
        if (sum >= m) {
            count += 1;
        }
//        if (count == 0) {
//            count = 1;
//        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        getFruit(3,3,new int[]{2,3,4});
        getFruit(3,3,new int[]{2,2,4});
        getFruit(3,3,new int[]{2,1,4});
        getFruit(2,5,new int[]{2,4});

        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        for(int i = 0; i < group; i++){
            long n = sc.nextInt();
            long m = sc.nextInt();
            long count = 0;
            long sum = 0;
            for (long j = 0; j < n; j++) {
                long num = sc.nextLong();
                if (num >= m) {
                    count++;
                }else {
                    sum += num;
                }
                if (sum >= m) {
                    count += 1;
                }
                System.out.println(count);
            }
//            getFruit(n,m,arr);
//            System.out.println(n);
//            System.out.println(m);
//            System.out.println(Arrays.toString(arr));
        }
    }
}
