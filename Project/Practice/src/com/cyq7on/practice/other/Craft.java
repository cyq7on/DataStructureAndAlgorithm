package com.cyq7on.practice.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Craft {
    public int getLongestPalindrome(String A, int n) {
        // write code here

        int maxLen = 1;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[n][n];
        char[] charArray = A.toCharArray();

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;

    }

    private int m;
    private int n;
    private int[][] grid;
    private long count;

    public int countWays(int[][] map, int x, int y) {
        // write code here
        this.grid = map;
        this.m = y;
        this.n = x;
        List<List<Integer>> ansList = new ArrayList<>();
        dfs(0, 0, new boolean[m][n], ansList);
//        return ansList.size() % 1000000007;
//        dfs(0, 0);
        return (int) (count % 1000000007);
//        return pathCount(map).size() % 1000000007;
    }

    private void dfs(int row,int col) {
        if (row >= m || col >= n || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;

        if (row == m - 1 && col == n - 1) {
            count++;
        }
        dfs(row + 1, col);
        dfs(row , col + 1);
    }

    private boolean dfs(int row, int col, boolean[][] visited, List<List<Integer>> pathList) {
        if (row >= m || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return false;
        }

//        pathList.add(Arrays.asList(row, col));
        if (row == m - 1 && col == n - 1) {
            count++;
            return true;
        }

        visited[row][col] = true;

        if (dfs(row + 1, col, visited, pathList) || dfs(row, col + 1, visited, pathList)) {
            return true;
        }

//        pathList.remove(pathList.size() - 1);
        return false;
    }

    public List<List<Integer>> pathWithObstacles(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        List<List<Integer>> ansList = new ArrayList<>();
        dfs(0, 0, new boolean[m][n], ansList);
        return ansList;
    }

    public List<List<Integer>> pathCount(int[][] obstacleGrid) {

        List<List<Integer>> route = new ArrayList<>();
        int h = obstacleGrid.length - 1;
        int w = obstacleGrid[0].length - 1;

        if (obstacleGrid[0][0] == 0 || obstacleGrid[h][w] == 0) {
            return route;
        }

        boolean[][] dp = new boolean[h + 1][w + 1];
        dp[0][0] = true;
        dp[h][w] = true;
        int x = 0;
        int y = 0;
        while (x < h || y < w) {
            dp[x][y] = true;
            if (x < h && obstacleGrid[x + 1][y] == 1) {
                x++;
                continue;
            }
            if (y < w && obstacleGrid[x][y + 1] == 1) {
                y++;
                continue;
            }
            if (x == 0 && y == 0) {
                return route;
            }
            dp[x][y] = false;
            obstacleGrid[x][y] = 0;
            if (x > 0 && dp[x - 1][y]) {
                x--;
            } else {
                y--;
            }
        }
        x = 0;
        y = 0;
        while (x < h || y < w) {
            route.add(Arrays.asList(x, y));
            if (x < h && dp[x + 1][y]) {
                x++;
            } else {
                y++;
            }
        }
        route.add(Arrays.asList(x, y));
        return route;
    }
}

