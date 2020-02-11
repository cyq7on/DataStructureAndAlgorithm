package com.cyq7on.practice.sort;

import java.util.Arrays;

public class MergeSort extends Sort {

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
//        mergeSortBU(arr);
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

    // 自底向上的归并排序
    public static void mergeSortBU(int[] arr) {
        for (int size = 1; size < arr.length; size *= 2) {
            for (int i = 0; i < arr.length - size; i += size + size) {
                merge(arr, i, i + size - 1, Math.min(i + size + size - 1, arr.length - 1));
            }
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

    public static void main(String[] args) {
        test(MergeSort.class.getName());
        test(MergeSort.class.getName(), 50000, 1, 10000);
    }
}
