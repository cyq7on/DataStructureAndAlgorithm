package com.cyq7on.leetcode.array;

/**
 * @author cyq7on
 * @description 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/3/11
 **/
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }

        int left = 0, leftSum = A[0];
        int right = A.length - 1, rightSum = A[right];
        //left < right则可能只分为两部分
        int k = sum / 3;
        while (left < right - 1) {
            if (leftSum == k && rightSum == k) {
                return true;
            }

            if (leftSum != k) {
                left++;
                leftSum += A[left];
            }

            if (rightSum != k) {
                right--;
                rightSum += A[right];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionArrayIntoThreePartsWithEqualSum equalSum = new PartitionArrayIntoThreePartsWithEqualSum();
        System.out.println(equalSum.canThreePartsEqualSum(new int[]{6, 1, 1, 13, -1, 0, -10, 20}));
    }

}
