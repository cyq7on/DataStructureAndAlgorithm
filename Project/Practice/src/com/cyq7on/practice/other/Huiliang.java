package com.cyq7on.practice.other;

import java.util.Scanner;

public class Huiliang {
    private int min = Integer.MIN_VALUE;

    // 中序遍历
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    // 内存消耗:39.4 MB,击败了76.14% 的Java用户
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= min) return false;
        min = root.val;
        return isValidBST(root.right);
    }

    public boolean checkBST(TreeNode root) {
        // write code here
        if (root == null) return true;
        if (!checkBST(root.left)) return false;
        if (root.val <= min) return false;
        min = root.val;
        return checkBST(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int countBag = scanner.nextInt();
        int[] vol = new int[n];
        for (int i = 0; i < n; i++) {
            vol[i] = scanner.nextInt();
        }


    }

    public static int knapsack01(int[] weight, int[] value, int c) {
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
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
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
