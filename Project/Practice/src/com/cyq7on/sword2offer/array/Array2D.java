package com.cyq7on.sword2offer.array;

import com.cyq7on.practice.array.BinarySearch;

public class Array2D {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (BinarySearch.binarySearch(arr, 0, arr.length, target) != -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Array2D array2D = new Array2D();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(array2D.findNumberIn2DArray(matrix, 5));
        System.out.println(array2D.findNumberIn2DArray(matrix, 20));
    }
}
