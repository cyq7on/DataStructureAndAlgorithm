package com.cyq7on.sword2offer.num;

import java.util.Arrays;

/**
* @description
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/2/20
**/
public class PrintNum {
    public int[] printNumbers(int n) {
        int i = 0;
        int max = 1;
        while (i++ < n) {
            max *= 10;
        }
        max--;
        int[] arr = new int[max];
        for (int j = 1; j <= max; j++) {
            arr[j - 1] = j;
        }
        return arr;
    }

    public static void printToMaxOfNDigits1(int n) {
        if(n <= 0) {
            return;
        }
        char[] nums = new char[n + 1];
        Arrays.fill(nums, '0');
        while(!increment(nums)) {
            printNum(nums);
        }
    }

    /**
     * 大数自增操作！
     * 并判断是否已经超出了n位了。
     * @param nums
     * @return
     */
    private static boolean increment(char[] nums) {
        int carry = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[i] - '0' + carry;
            //因为是加1，所以肯定是在最后一位上加1了
            if(i == nums.length - 1) {
                temp++;
            }
            carry = temp / 10;
            temp %= 10;
            nums[i] = (char)(temp + '0');
        }
        return nums[0] == '1';
    }


    public static void printToMaxOfNDigits2(int n) {
        if(n <= 0) {
            return;
        }
        char[] nums = new char[n];
        recursiveProductNum(0, n, nums);
    }

    private static void recursiveProductNum(int index, int length, char[] nums) {
        if(index == length) {
            printNum(nums);
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            nums[index] = i;
            recursiveProductNum(index + 1, length, nums);
        }
    }

    private static void printNum(char[] nums) {
        int index = 0;
        for(; index < nums.length; index++) {
            if(nums[index] != '0'){
                break;
            }
        }
        for(; index < nums.length; index++) {
            System.out.print(nums[index]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintNum.printToMaxOfNDigits2(2);
    }
}
