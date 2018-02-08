package com.cyq7on.leetcode;

import java.util.Arrays;

/**
 * Created by cyq7on on 18-2-8.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] sum = twoSum(new int[]{5, 75, 25}, 100);
        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        int sum = nums[low] + nums[high];
        while (sum != target) {
            if (sum < target) {
                low++;
            } else {
                high--;
            }
            sum = nums[low] + nums[high];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[low] == copy[i]) {
                low = i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[high] == copy[i] && i != low) {
                high = i;
                break;
            }
        }
        return new int[]{low, high};
    }
}
