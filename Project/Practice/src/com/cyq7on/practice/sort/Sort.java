package com.cyq7on.practice.sort;

public class Sort {
    protected static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    protected static void test(String className) {
        test(className,10,1,10);
    }

    protected static void test(String className,int n, int rangeL, int rangeR) {
        int[] arr = SortTestHelper.generateRandomArray(n, rangeL, rangeR);
        SortTestHelper.testSort(className, arr);
    }
}
