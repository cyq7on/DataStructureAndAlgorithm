package com.cyq7on.practice.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeftRight {

    private static Map<Integer,Integer> mapLeft;
    private static Map<Integer,Integer> mapRight;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int size = (int) (n / 0.75f + 1);
        mapLeft = new HashMap<>(size);
        mapRight = new HashMap<>(size);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(getRes(arr));

    }

    private static int getRes(int[] arr) {
        int max = 0;
        for (int i = 1; i <= arr.length; i++) {
            max = Math.max(max, getLeft(arr, i) * getRight(arr, i));
        }
        return max;
    }

    private static int getLeft(int[] arr,int i) {
        Integer index = mapLeft.getOrDefault(i, -1);
        if (index != -1 && index < i) {
            return index;
        }
        for(int j = i - 1;j >= 1;j--) {
            if (arr[j - 1] > arr[i - 1]) {
                mapLeft.put(i, j);
                return j;
            }
        }
        return 0;
    }

    private static int getRight(int[] arr,int i) {
        Integer index = mapRight.getOrDefault(i, -1);
        if (index != -1 && index > i) {
            return index;
        }
        for(int j = i + 1;j <= arr.length;j++) {
            if (arr[j - 1] > arr[i - 1]) {
                mapRight.put(i, j);
                return j;
            }
        }
        return 0;
    }
}
