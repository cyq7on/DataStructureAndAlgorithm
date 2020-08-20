package com.cyq7on.practice.mt;

import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> {
    public void sort(T[] arr) {
        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ )
                if( arr[j].compareTo( arr[minIndex] ) > 0 ){
                    minIndex = j;
                }

            swap( arr , i , minIndex);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1,3,2,5};
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
