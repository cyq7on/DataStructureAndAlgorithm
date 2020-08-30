package com.cyq7on.practice.other;

import java.util.Arrays;
import java.util.Scanner;

public class Xiaohongshu {
    static int MAX = 20;
    static int INF = Integer.MAX_VALUE;
    static int n, m, r, c;
    static int[][] a = new int[MAX][MAX];
    static int[] lc = new int[MAX];
    static int[][] hc = new int[MAX][MAX];
    static int[][] f = new int[MAX][MAX];
    static int[] vish = new int[MAX];
    static int ans;

    private static void init() {
        for (int i = 1; i <= m; i++)
            lc[i] = 0;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= m; j++)
                hc[i][j] = 0;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j < r; j++)
                lc[i] += Math.abs(a[vish[j]][i] - a[vish[j + 1]][i]);
        for (int i = 2; i <= m; i++)
            for (int j = 1; j < i; j++)
                for (int k = 1; k <= r; k++)
                    hc[i][j] += Math.abs(a[vish[k]][i] - a[vish[k]][j]);
    }

    private static void getRes() {
        f[1][1] = lc[1];
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= (i < c ? i : c); j++) {
                f[i][j] = INF;
                if (j == 1) f[i][j] = lc[i];
                else if (i == j) f[i][j] = f[i - 1][j - 1] + hc[i][j - 1] + lc[i];
                else {
                    for (int k = i - 1; k >= j - 1; k--)
                        f[i][j] = Math.min(f[i][j], f[k][j - 1] + hc[i][k] + lc[i]);
                }
                if (j == c) ans = Math.min(ans, f[i][c]);
            }
        }
    }

    private static void dfs(int k, int j)
    {
        if (k == r + 1) {
            init();
            getRes();
            return;
        }
        for (int i = j + 1; i <= n; i++) {
            vish[k] = i;
            dfs(k + 1, i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = in.nextInt();
            }
        }
        System.out.println(getMax(data));
        /*r = in.nextInt();
        c = in.nextInt();
        ans = INF;
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                a[i][j] = in.nextInt();
        dfs(1, 0);

        System.out.println(ans);*/
    }

    private static int getMax(int[][] data) {
        if(data.length == 0)        return 0;
        Arrays.sort(data, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] dp = new int[data.length];
        int maxLen = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < data.length; i++)
        {
            for(int j = 0; j < i; j++)
                if(data[j][1] < data[i][1])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }


}
