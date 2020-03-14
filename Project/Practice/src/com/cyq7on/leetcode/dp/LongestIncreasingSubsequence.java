package com.cyq7on.leetcode.dp;

import java.util.Arrays;

/**
* @description
 *给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/3/14
**/
public class LongestIncreasingSubsequence {
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        //dp[i] 的值代表 nums 前 i(i>0) 个数字的最长子序列长度。
        int[] dp = new int[length];
        //dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
