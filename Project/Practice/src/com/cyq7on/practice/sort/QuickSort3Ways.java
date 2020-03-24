package com.cyq7on.practice.sort;


public class QuickSort3Ways extends Sort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(arr, left, (int) ((right - left) * Math.random() + left));
        int pivot = arr[left];

        int lt = left;     // arr[l+1,lt] < v
        int gt = right + 1; // arr[gt,r] > v
        int i = left + 1;    // arr[lt+1,i) == v
        while (i < gt) {
            if (arr[i] > pivot) {
                swap(arr, i, gt - 1);
                gt--;
            } else if (arr[i] < pivot) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else {
                i++;
            }
        }
        swap(arr, left, lt);
        //注意lt是left，等于v，所以需要-1
        quickSort(arr, left, lt - 1);
        quickSort(arr, gt, right);
    }


    public static void main(String[] args) {
        test(InsertionSort.class.getName(), 50000, 1, 10);
        test(SelectionSort.class.getName(), 50000, 1, 10);
        test(QuickSort3Ways.class.getName(), 50000, 1, 10);
        test(QuickSort2Ways.class.getName(), 50000, 1, 10);
        test(QuickSort.class.getName(), 50000, 1, 10);
    }
}
