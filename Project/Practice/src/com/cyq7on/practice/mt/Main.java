package com.cyq7on.practice.mt;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> res = getRes(n);
        System.out.println(res.size());
        for (String s : res) {
            System.out.println(s);
        }
    }

    private static List<String> getRes(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 10; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (200 * i + 10 * j + 12 * k == n) {
                        list.add(String.format("%s%s%s %s%s%S",i,j,k,i,k,k));
                    }
                }
            }
        }
        return list;
    }

    int[] dx = {-1,0,1,0};
    int[] dy={0,1,0,-1};
    // 记忆化搜索
    public int helper(int x, int y, int[][] dp, int[][] matrix){
        if(dp[x][y]!=-1) return dp[x][y];
        dp[x][y] = 1;     // 从这个点开始搜索
        for(int i=0;i<4;i++){
            int a = x+dx[i];
            int b = y+dy[i];
            if(a>=0 && a<matrix.length &&
                    b>=0 && b< matrix[0].length &&
                    matrix[x][y]>matrix[a][b]){
                dp[x][y] = Math.max(dp[x][y],helper(a,b,dp,matrix)+1);
            }
        }
        return dp[x][y];
    }
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int [][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int res = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res = Math.max(res,helper(i,j,dp,matrix));
            }
        }
        return res;
    }


    static class Bean {
        public int band;
        public int val;

        public Bean(int band, int val) {
            this.band = band;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "band=" + band +
                    ", val=" + val +
                    '}';
        }
    }


    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { //物品
            for (int j = 1; j <= w; j++) {  //背包大小
                if (weight[i] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    table[i][j] = table[i - 1][j];
                } else { //装得下，Max{装物品i， 不装物品i}
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return table[n][w];
    }

    public static int knapsack01(float[] weight, int[] value, int c) {
        int n = weight.length;
        // 如果没有物品可选，最大价值就是0
        if (n == 0)
            return 0;

        // 注意：在图示中，物品从 0 开始编号，则物品 0 占据一个位置
        // 同理，容量 C 也是从 0 开始编号的，因此 [0, C+1) 就表示容量为 C 的背包
        int[][] dp = new int[n][c + 1];


        /*
        脑海里开始浮现视频中这张图的解析过程，一边回想一边写算法
         */


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
                    // 然后计算【放入后获得的价值最大值】与上面【不放进去的价值】的最大值
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][(int) (j - weight[i])] + value[i]);
                }
            }
        }
        /*
        之前设置的dp大小为：[n][c + 1]
        那是因为物品是从0开始编号的，3个物品就是0,1,2
        但是容量是从0开始模拟的，所以容量为5的时候其实要从0开始遍历，所以数组的大小开辟成[n][c + 1]
         */

        // 最大价值就存储在 dp 的最后一格
        return dp[n - 1][c];
    }

}




