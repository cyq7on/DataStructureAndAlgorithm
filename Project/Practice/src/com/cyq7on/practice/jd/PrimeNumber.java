package com.cyq7on.practice.jd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int count = 0;
//        String nStr = String.valueOf(n);
//        String mStr = String.valueOf(m);
//        int start = (int) Math.pow(10, nStr.length() - 2);
//        int end = (int) Math.pow(10, mStr.length() - 1) - 1;
        for (int i = n; i <= m; i++) {
            Set<Integer> set = new HashSet<>();
            String str = String.valueOf(i);
            int len = str.length();
            String temp;
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    temp = str.substring(1, len);
                }
                else if (j == len - 1) {
                    temp = str.substring(0, j);
                }
                else {
                    temp = str.substring(0, j) + str.substring(j + 1, len);
                }
                int num = Integer.parseInt(temp);
                if (!set.contains(num) && isValid(num)) {
                    count++;
                }
                set.add(num);
            }
        }

        /*for (int i = start; i <= end; i++) {
            String iStr = String.valueOf(i);
            if (isPrime(i) && isValid(i) && (nStr.contains(iStr) || mStr.contains(iStr))) {
                count++;
            }
        }*/
        System.out.println(count);
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    private static boolean isValid(int num) {
        if (isPrime(num)) {
            int n = num;
            int result = 0;
            while (num != 0) {
                int temp = num % 10;
                result = result * 10 + temp;
                num /= 10;
            }
            return result == n;
        }
        return false;
    }
}
