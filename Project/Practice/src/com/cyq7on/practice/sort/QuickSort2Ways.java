package com.cyq7on.practice.sort;


public class QuickSort2Ways extends Sort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition);
        quickSort(arr, partition + 1, right);
    }

    // 对[l,r]部分进行partition操作
    // 返回p, 使得arr[l,p-1] <= arr[p] ; arr[p+1,r] >= arr[p]
    private static int partition(int[] arr, int left, int right) {
        swap(arr, left, (int) ((right - left) * Math.random() + left));
        int pivot = arr[left];
        // arr[l+1,i) <= v; arr(j,r] >= v
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && arr[i] < pivot) {
                i++;
            }
            while (j >= left + 1 && arr[j] > pivot) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr, left, j);
        return j;
    }

    public static void main(String[] args) {
        test(InsertionSort.class.getName(), 10000, 1, 10);
        test(SelectionSort.class.getName(), 10000, 1, 10);
        test(QuickSort2Ways.class.getName(), 10000, 1, 10);
        test(QuickSort.class.getName(), 10000, 1, 10);
    }
}
