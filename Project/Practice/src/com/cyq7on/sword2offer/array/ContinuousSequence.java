package com.cyq7on.sword2offer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @description
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/3/6
**/
public class ContinuousSequence {
    //滑动窗口左闭右开
    public int[][] findContinuousSequence(int target) {
        int left = 1,right = 1;
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            }else if (sum > target) {
                sum -= left;
                left++;
            }else if (sum == target) {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                list.add(arr);
                sum -= left;
                left += 1;
            }
        }
        return list.toArray(new int[0][]);
    }

    public int[][] findContinuousSequence0(int target) {
        if(target == 1) {
            return new int[0][0];
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= (target + 1) / 2; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int j = i; j <= (target + 1) / 2; j++) {
                list.add(j);
                sum += j;
                if (sum == target) {
                    break;
                }else if (sum > target) {
                    list = null;
                    break;
                }
            }
            if (sum == target) {
                lists.add(list);
            }
        }
        int[][] arr = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                ints[j] = list.get(j);
            }
            arr[i] = ints;
        }
        return arr;
    }

    public static void main(String[] args) {
        ContinuousSequence continuousSequence = new ContinuousSequence();
        System.out.println(Arrays.toString(continuousSequence.findContinuousSequence(9)));
        System.out.println(Arrays.toString(continuousSequence.findContinuousSequence(15)));
    }
}
