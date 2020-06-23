package com.cyq7on.sword2offer.dp;

/**
* @description
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
* @author cyq7on
* @create 2020/6/20
**/
public class Jump {
    public int JumpFloorII(int target) {
        if(target <= 1) {
            return 1;
        }

        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= target; i++) {
            for(int j = 1;j < i; j++) {
                dp[i] += dp[i - j];
            }
            //一次性跳n阶是一种跳法
            dp[i]++;
        }
        return dp[target];
    }
}
