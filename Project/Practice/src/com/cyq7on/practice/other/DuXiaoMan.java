package com.cyq7on.practice.other;

import java.util.Scanner;

public class DuXiaoMan {
    private static int count;
    private static boolean flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(-1);
        }
        /*String color = scanner.nextLine();
        String target = scanner.nextLine();
        int[] counts = new int[26];
        for (char c : color.toCharArray()) {
            int index = c - 'A';
            counts[index]++;
        }
        System.out.println(getCount(counts, target));*/
    }

    private static void dfs(char[][] matrix,int i,int j,int n,int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] == '#' || matrix[i][j] == 'A') {
            return;
        }

        if (matrix[i][j] == '*') {
            count++;
        }
        char temp = matrix[i][j];
        matrix[i][j] = 'A';

        if (i == 0 || i == n - 1 || j == 0 || j == m -1) {
            flag  = true;
            return;
        }
        dfs(matrix,i + 1,j,n,m);
    }

    private static int getCount(int[] times, String target) {
        int count = 0;
        for (char c : target.toCharArray()) {
            int index = c - 'A';
            if (times[index] > 0) {
                count++;
                times[index]--;
            }
        }
        return count;
    }
}
