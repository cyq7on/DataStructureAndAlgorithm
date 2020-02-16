package com.cyq7on.sword2offer.array;

/**
 * @author cyq7on
 * @description Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 * <p>
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/15
 **/
public class RotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                //这是剑指offer解法，更优解法如下：
//                return iterFindMin(nums);
                right--;
            }
        }
        return nums[right];
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int index = 0;
        while (index <= nums.length - 1 && nums[index] >= nums[0]){
            index++;
        }
        int search = search(nums, target, 0, index - 1);
        if (search >= 0) {
            return search;
        }
        return search(nums, target, index, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    private int iterFindMin(int[] nums) {
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pre) {
                pre = nums[i];
                break;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        System.out.println(rotatedSortedArray.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(rotatedSortedArray.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(rotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(rotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(rotatedSortedArray.search(new int[]{1,3}, 0));
        System.out.println(rotatedSortedArray.search(new int[]{5,1,3}, 5));
    }
}
