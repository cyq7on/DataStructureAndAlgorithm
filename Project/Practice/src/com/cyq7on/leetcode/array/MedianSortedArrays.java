package com.cyq7on.leetcode.array;

/**
* @description
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *  
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/7/6
**/
public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0,j = 0,k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            }else {
                arr[k++] = nums2[j++];
            }
        }

        while (i < nums1.length ) {
            arr[k++] = nums1[i++];
        }

        while (j < nums2.length ) {
            arr[k++] = nums2[j++];
        }

        if (arr.length % 2 != 0) {
            return arr[arr.length / 2];
        }else {
            int index = arr.length / 2;
            return (arr[index - 1] + arr[index]) * 1.0 / 2;
        }

    }

    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0,j = 0,k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            }else {
                arr[k++] = nums2[j++];
            }
        }

        while (i < nums1.length ) {
            arr[k++] = nums1[i++];
        }

        while (j < nums2.length ) {
            arr[k++] = nums2[j++];
        }

        if (arr.length % 2 != 0) {
            return arr[arr.length / 2];
        }else {
            int index = arr.length / 2;
            return (arr[index - 1] + arr[index]) * 1.0 / 2;
        }

    }

    public static void main(String[] args) {
        MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
        System.out.println(medianSortedArrays.findMedianSortedArrays(new int[] {1,2},new int[]{3,4}));
    }
}
