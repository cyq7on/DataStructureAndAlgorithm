package com.cyq7on.practice.bytedance;

import java.util.Scanner;

public class Main {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        int[] tem = new int[3];
        for (int i = 0; i < 3; i++) {
            tem[i] = ((r - i) / 3 - (l - i - 1) / 3);
        }
        int x = tem[0], y = tem[1], z = tem[2];
        for (int i = 1; i <= n; i++) {
            int t1 = (x * tem[0] + y * tem[2] + z * tem[1]) % mod;
            int t2 = (x * tem[1] + z * tem[2] + y * tem[0]) % mod;
            int t3 = (x * tem[2] + y * tem[1] + z * tem[0]) % mod;
            x = t1;
            y = t2;
            z = t3;
        }
        System.out.println(x);
    }


}

