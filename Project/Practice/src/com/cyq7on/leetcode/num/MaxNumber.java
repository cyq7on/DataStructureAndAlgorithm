package com.cyq7on.leetcode.num;

import java.util.*;

/**
 * @author cyq7on
 * @description 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 * <p>
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 * <p>
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/8/17
 **/
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[0];
        //最少可以从nums1取min个
        int min = Math.max(0, k - nums2.length);
        //最多可以从nums1取max个
        int max = Math.min(k, nums1.length);
        for (int i = min; i <= max; i++) {
            int[] kLarge1 = getKLarge(nums1, i);
            int[] kLarge2 = getKLarge(nums2, k - i);
            int[] merge = merge(kLarge1, kLarge2);
            if (bigger(merge, res)) {
                res = merge;
            }
        }
        return res;
    }

    private boolean bigger(int[] nums1, int[] nums2) {
        return bigger(nums1, nums2, 0, 0);
    }

    private boolean bigger(int[] nums1, int[] nums2,int index1,int index2) {
        if (nums2.length == 0) {
            return true;
        }
        int i = 0;
        while (i + index1 < nums1.length && i + index2 < nums2.length) {
            if (nums1[i + index1] > nums2[i + index2]) {
                return true;
            } else if (nums1[i + index1] < nums2[i + index2]) {
                return false;
            }
            i++;
        }
        return nums1.length >= nums2.length;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                num[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]){
                num[k++] = nums2[j++];
            }else {
                if (bigger(nums1,nums2,i + 1,j + 1)) {
                    num[k++] = nums1[i++];
                }else {
                    num[k++] = nums2[j++];
                }
            }
        }
        while (i < nums1.length) {
            num[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            num[k++] = nums2[j++];
        }
        return num;
    }

    private int[] getKLarge(int[] nums, int k) {
        int[] res = new int[k];
        int count = nums.length - k;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            while (!stack.isEmpty() && count > 0 && stack.peekLast() < num) {
                stack.removeLast();
                count--;
            }
            stack.addLast(num);
        }

        for (int i = 0; i < count; i++) {
            stack.removeLast();
        }

        int i = 0;
        for (int num : stack) {
            res[i++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();
        System.out.println(Arrays.toString(maxNumber.maxNumber(new int[]{6,7}, new int[]{6,0,4}, 5)));
        System.out.println(Arrays.toString(maxNumber.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
    }
}
