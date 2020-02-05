package com.cyq7on.practice.stackandqueue;

import java.util.LinkedList;

/**
 * Created by cyq7on on 17-2-22.
 */
public class SlidingWindowMaxArray {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        SlidingWindowMaxArray array = new SlidingWindowMaxArray();
        int[] maxInWindow = array.getMaxInWindow(arr, w);
        for (int i = 0; i < maxInWindow.length; i++) {
            System.out.println(maxInWindow[i]);
        }
    }

    public int[] getMaxInWindow(int[] arr,int w) {
        int length = arr.length;
        if (arr == null || w < 1 || length < w){
            return null;
        }
        int index = 0;
        int[] res = new int[length - w + 1];
        LinkedList<Integer> maxList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[i]) {
                maxList.pollLast();
            }
            maxList.addLast(i);
            if (maxList.peekFirst() == i - w) {
                maxList.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[maxList.peekFirst()];
            }
        }
        return res;
    }
}
