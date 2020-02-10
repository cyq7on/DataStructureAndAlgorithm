package com.cyq7on.practice.sort;

public class ShellSort extends Sort {

    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //插入排序
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                for (; j - gap > 0 && temp > arr[j]; j = j - gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        test(ShellSort.class.getName(),10000,1,10000);
    }
}
