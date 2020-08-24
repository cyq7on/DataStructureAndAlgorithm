package com.cyq7on.practice.other;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 20 || n < 1) {
            System.out.println("error");
            return;
        }
        int[][] matrix = new int[n][n];

        int left = 0,top = 0,right = n - 1,bottom = n - 1;
        int count = 1;
        while(true) {
            for(int i = top;i <= bottom;i++) {
                matrix[i][right] = count++;
            }
            if(--right < left) {
                break;
            }

            for(int i = right;i >= left;i--) {
                matrix[bottom][i] = count++;
            }
            if(--bottom < top) {
                break;
            }

            for(int i = bottom;i >= top;i--) {
                matrix[i][left] = count++;
            }
            if(++left > right) {
                break;
            }

            for(int i = left;i <= right;i++) {
                matrix[top][i] = count++;
            }
            if(++top > bottom) {
                break;
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%4d",matrix[i][j]));
                if (j < matrix[0].length - 1) {
                    System.out.print(" ");
                }
            }
            if (i < matrix.length - 1) {
                System.out.print("\n");
            }
        }
    }

}
