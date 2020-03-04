package com.cyq7on.sword2offer.array;

import java.util.Arrays;

/**
* @description
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/3/4
**/
public class LeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int partition = partition(arr, 0, arr.length - 1);
        while (partition != k - 1) {
            if (partition > k - 1) {
                partition = partition(arr,0,partition - 1);
            }else {
                partition = partition(arr, partition + 1, arr.length - 1);
            }
        }
        return Arrays.copyOf(arr, k);
    }

    private int partition(int[] arr,int left,int right) {
        int pivot = arr[left];
        int j = left;

        for (int i = j + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr,i,j + 1);
                j++;
            }
        }
        swap(arr,left,j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
