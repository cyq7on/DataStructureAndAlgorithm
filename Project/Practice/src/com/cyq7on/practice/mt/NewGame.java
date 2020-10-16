package com.cyq7on.practice.mt;

import java.util.Scanner;

public class NewGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        char[][] arr = new char[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chars[j];
                if (chars[j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        int count = 0;
        char[] chars = scanner.nextLine().toCharArray();
        for (char ch : chars) {
            int temp;
            switch (ch) {
                case 'A':
                    temp = y - 1;
                    if (temp >= 0 && arr[x][temp] != '#') {
                        y = temp;
                    }
                    break;
                case 'W':
                    temp = x - 1;
                    if (temp >= 0 && arr[temp][y] != '#') {
                        x = temp;
                    }
                    break;
                case 'D':
                    temp = y + 1;
                    if (temp < n && arr[x][temp] != '#') {
                        y = temp;
                    }
                    break;
                case 'S':
                    temp = x + 1;
                    if (temp < m && arr[temp][y] != '#') {
                        x = temp;
                    }
                    break;
                /*default:
                    temp = x + 1;
                    if (temp < m  && arr[temp][y] != '#') {
                        x = temp;
                    }
                    break;*/
            }

            if (arr[x][y] == 'O') {
                count += p;
                arr[x][y] = '+';
            } else if (arr[x][y] == 'X') {
                count -= q;
                arr[x][y] = '+';
            }
        }
        System.out.println(count);
    }
}
