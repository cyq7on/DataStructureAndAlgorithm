package com.cyq7on.sword2offer.num;

/**
* @description
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/8/4
**/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            int flag = 1;
            for(int i = counts.length - 1;i >= 0;i--) {
                counts[i] += num & flag;
                flag <<= 1;
            }
        }

        int res = 0;

        for(int i = 0;i < counts.length;i++) {
            res <<= 1;
            res |= counts[i] % 3;
        }

        return res;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[] {3,4,3,3}));
    }
}
