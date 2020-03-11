package com.cyq7on.leetcode.dp;

/**
* @description
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 解法：
 * https://leetcode-cn.com/problems/coin-change/solution/zi-di-xiang-shang-dong-tai-gui-hua-by-pendygg/
* @author cyq7on
* @create 2020/3/9
**/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        //dp[i]表示兑换金额为i时所需的最小币数
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        int res = dp[dp.length - 1];
        return res == amount + 1 ? -1 : res;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5},11));
    }
}