package com.cyq7on.practice.other;


import java.util.Scanner;

public class Xunfei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solve(n);
    }

    public static void solve(int n) {
        for (int i = 2; i <= n; i++) {
            if (i == n) {
                System.out.print(i);
                return;
            }
            if (n % i == 0) {
                System.out.print(i + "*");
                solve(n / i);
                break;
            }
        }
    }

    public static void sort(int[] a, int low, int high) {
        int i, j, index;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        index = a[i];
        while (i < j) {
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];
            while (i < j && a[i] < index)
                i++;
            if (i < j)
                a[j--] = a[i];
        }
        a[i] = index;
        sort(a, low, i - 1);
        sort(a, i + 1, high);

    }

    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

}
