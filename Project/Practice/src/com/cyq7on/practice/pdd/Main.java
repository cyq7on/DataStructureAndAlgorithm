package com.cyq7on.practice.pdd;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= n / 2) {
                    if (j <= n / 2) {
                        if (i + j <= n - 1) {
                            arr[i][j] = 1;
                        }else {
                            arr[i][j] = 8;
                        }
                    }else {
                        if (i + j < n - 1) {
                            arr[i][j] = 7;
                        }else {
                            arr[i][j] = 6;
                        }
                    }
                }else {
                    if (j < n / 2) {
                        if (i + j < n - 1) {
                            arr[i][j] = 2;
                        }else {
                            arr[i][j] = 3;
                        }
                    }else {
                        if (i + j < n - 1) {
                            arr[i][j] = 4;
                        }else {
                            arr[i][j] = 5;
                        }
                    }
                }

                if (i == j || (i + j) == n - 1) {
                    arr[i][j] = 0;
                }

                if (n % 2 != 0 && (i == n / 2 || j == n / 2 )) {
                    arr[i][j] = 0;
                }
                System.out.println(arr);
            }
        }

    }

    public static int knapsack01(int[] weight, int[] value, int c) {
        int n = weight.length;
        // 如果没有物品可选，最大价值就是0
        if (n == 0)
            return 0;

        // 注意：在图示中，物品从 0 开始编号，则物品 0 占据一个位置
        // 同理，容量 C 也是从 0 开始编号的，因此 [0, C+1) 就表示容量为 C 的背包
        int[][] dp = new int[n][c * 2];


        // 先处理表格中第一行
        // 从背包容量为0开始到背包满了。检查第0号物品能否放入背包
        for (int j = 0; j <= c; j++) {
            dp[0][j] = (j >= weight[0]) ? value[0] : 0;
        }

        // 然后开始从表格的第二行开始处理
        for (int i = 1; i < n; i++) { // 注意这里不是 <=n，因为i是从0开始的
            // 然后也是从背包容量为0开始检查当前i号物品能否存入背包
            for (int j = 0; j <= c; j++) {
                // 从第二行开始的计算要依赖于之前的计算结果

                dp[i][j] = dp[i - 1][j];//表示不把第i个物品放入背包，任然使用第i-1号物品的最大价值

                // 若准备尝试把第i个物品存入背包的话，得先保证能放进去
                if (j >= weight[i]) {
                    if (weight[i] < 0) {
                        dp[i - 1][j - weight[i]] = dp[i][j];
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 最大价值就存储在 dp 的最后一格
        return dp[n - 1][c];
    }
}
