package com.cyq7on.practice.sort;

public class SelectionSort extends Sort {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    public static void main(String[] args) {
        test(SelectionSort.class.getName());
    }
}
