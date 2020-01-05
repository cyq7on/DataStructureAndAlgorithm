package com.cyq7on.leetcode.dp;

/**
* @description
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
* @author cyq7on
* @create 2020/1/5
**/
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int temp = nums[nums.length - 1];
        nums[nums.length - 1] = 0;
        int max1 = robMax(nums);
        nums[0] = 0;
        nums[nums.length - 1] = temp;
        return Math.max(max1, robMax(nums));
    }

    // from HouseRobber
    private int robMax(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(new int[] {1,2,1,1}));
        System.out.println(houseRobberII.rob(new int[] {2,3,2}));
    }
}
