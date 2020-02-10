package com.cyq7on.practice.sort;

public class Sort {
    protected static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
