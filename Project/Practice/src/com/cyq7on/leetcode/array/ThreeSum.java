package com.cyq7on.leetcode.array;

import java.util.*;

/**
 * @author cyq7on
 * @description Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/10
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = twoSum(nums, -nums[i], i);
            if (list != null && notContainsAll(lists,list)) {
//                list.add(nums[i]);
                lists.add(list);
            }
        }
        return lists;
    }

    private boolean notContainsAll(List<List<Integer>> lists, List<Integer> list) {
        for (List<Integer> integerList : lists) {
            int count = 0;
            for (Integer integer : list) {
                if (integerList.contains(integer)) {
                    count ++;
                }
            }
            if (count == list.size()) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> twoSum(int[] nums, int target, int excludeIndex) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>(2);
        for (int i = 0; i < nums.length; i++) {
            if (i == excludeIndex) {
                continue;
            }
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                ans.add(diff);
                ans.add(nums[i]);
                ans.add(-target);
                return ans;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
//        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        List<List<Integer>> lists = threeSum.threeSum(new int[]{-2,0,1,1,2});
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        System.out.println(lists);
    }
}
