package com.cyq7on.leetcode.dp;


/**
 * @author cyq7on
 * @description Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * @create 2020/1/2
 **/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0],max = nums[0];
        for(int i = 1;i < nums.length;i++) {
            //和小于0则丢弃之前的sum
            if(sum <= 0) {
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            //记录最大值
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    //Runtime: 66 ms, faster than 5.90% of Java online submissions for Maximum Subarray.
    //Memory Usage: 40.3 MB, less than 5.16% of Java online submissions for Maximum Subarray.
    public int maxSubArray3(int[] nums) {
        int length = nums.length;
        //dp[i]表示数组开始索引为i的子数组的和
        int[] dp = new int[length];
        int max = nums[0] - 1;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int sum = dp[i] + nums[j];
                dp[i] = sum;
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

    //Memory Limit Exceeded
    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        //dp[i][j]表示数组索引为[i,j]的子数组的和
        int[][] dp = new int[length][length];
        dp[0][0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[0][i - 1] + nums[i];
            if (max < dp[0][i]) {
                max = dp[0][i];
            }
        }
        for (int i = 1; i < length; i++) {
            for (int j = i; j < length; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    //Time Limit Exceeded
    private int sum(int start, int end, int[] nums) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
//        System.out.println(maximumSubarray.maxSubArray(new int[]{1, 2}));
//        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
