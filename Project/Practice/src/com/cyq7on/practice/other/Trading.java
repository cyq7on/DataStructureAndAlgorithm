package com.cyq7on.practice.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Trading {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[p];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int[] arr = new int[14];
        for (int i = 0; i < 7; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] last = new int[]{3500, 4320, 4890, 5000, 5340, 6003, 6688};

        for (int i = 7; i < 14; i++) {
            arr[i] = last[i - 7];
        }
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // 递归使用归并排序,对[l,r]的范围进行排序
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        //优化，已经有序则不需要再归并
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, left, mid, right);
        }
    }

    // 将[l,mid]和[mid+1,r]两部分进行归并
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] arr1 = Arrays.copyOfRange(arr, left, mid + 1);
        int[] arr2 = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
    }
}
