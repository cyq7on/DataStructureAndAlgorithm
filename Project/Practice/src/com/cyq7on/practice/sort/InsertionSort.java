package com.cyq7on.practice.sort;

public class InsertionSort extends Sort {

    //优化写法
    public static void sort(int[] arr) {
        //从1开始，因为arr[0]不可能再插入到前面了
        for (int i = 1; i < arr.length; i++) {
            // 寻找元素arr[i]合适的插入位置
            int temp = arr[i];
            int j;
            for (j = i - 1; j > 0 && temp > arr[j]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void sort0(int[] arr) {
        //从1开始，因为arr[0]不可能再插入到前面了
        for (int i = 1; i < arr.length; i++) {
            // 寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr,j,j - 1);
            }
        }
    }

    public static void main(String[] args) {
        test(InsertionSort.class.getName(),10000,1,10000);
        test(SelectionSort.class.getName(),10000,1,10000);
    }
}
