package com.cyq7on.practice.ali;

import java.util.Scanner;

public class DictSort {
    public static void main(String[] args) {
//        System.out.println(getNum("z","a"));
//        System.out.println(getNum("a","z"));
//        System.out.println(getNum("az","bb"));
//        System.out.println(getNum("bbb","bbb"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            String A = scanner.next();
            String B = scanner.next();
            int num = getNum(A, B);
            System.out.println(num);
        }
    }

    private static int getNum(String a, String b) {
        if (a.compareTo(b) >= 0) {
            return 0;
        }

        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        int len = a.length();
        int diff = 0;
//        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < len; i++) {
//            sum1 = sum1 * 26 + charsa[i] - 'a';
//            sum2 = sum2 * 26 + charsb[i] - 'a';
            diff = diff * 26 + charsb[i] - charsa[i] - 1;
        }
        return diff >= 0 ? diff : 0;
    }
}
