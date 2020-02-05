package com.cyq7on.practice.array;

public class BinarySearch {
    public static int binarySearch(int[] array, int start, int end, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (end > array.length) {
            end = array.length - 1;
        }
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 9, 23, 100};
        System.out.println(binarySearch(array,0,5,4));
        System.out.println(binarySearch(array,0,5,3));
        System.out.println(binarySearch(array,0,5,100));
        System.out.println(binarySearch(array,0,6,100));
    }
}
