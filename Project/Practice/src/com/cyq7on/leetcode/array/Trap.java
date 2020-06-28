package com.cyq7on.leetcode.array;

/**
* @description
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/6/28
**/
public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int leftMax = 0,rightMax = 0;
        int left = 0,right = height.length - 1;
        int sum = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                sum += leftMax - height[left];
                left++;
            }else {
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}
