package com.cyq7on.practice.jd;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / (5 * (2 * i - 1)) - 1.0 / (5 * 2 * i);
        }
        System.out.println(String.format("%.4f",sum));
    }
}
