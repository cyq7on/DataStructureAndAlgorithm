package com.cyq7on.practice.sort;


public class QuickSort extends Sort{

    public static void sort(int[] arr) {
        quickSort(arr,0,arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }
        int partition = partition(arr, left, right);
        quickSort(arr,left,partition);
        quickSort(arr,partition + 1,right);
    }

    // 对[l,r]部分进行partition操作
    // 返回p, 使得arr[l,p-1] < arr[p] ; arr[p+1,r] > arr[p]
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr,j + 1,i);
                j++;
            }
        }
        swap(arr,left,j);
        return j;
    }

    public static void main(String[] args){
        test(InsertionSort.class.getName(),10000,1,10000);
        test(SelectionSort.class.getName(),10000,1,10000);
        test(QuickSort.class.getName(),10000,1,10000);
    }
}
