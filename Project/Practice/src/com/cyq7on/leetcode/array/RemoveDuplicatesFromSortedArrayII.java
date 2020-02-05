package com.cyq7on.leetcode.array;

import java.util.Arrays;

/**
 * @author cyq7on
 * @description Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/5
 **/
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int duplicateVal = nums[0];
        int index = 1;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != duplicateVal) {
                nums[index++] = nums[i];
                duplicateVal = nums[i];
                flag = true;
            }else if (flag) {
                nums[index++] = nums[i];
                flag = false;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArrayII();
        int[] array = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(array));
        System.out.println(Arrays.toString(array));
        array = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }
}
