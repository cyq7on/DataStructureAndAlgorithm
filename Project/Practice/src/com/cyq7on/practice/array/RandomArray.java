package com.cyq7on.practice.array;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {

    public static void main(String[] args) {
        int[] randomArray = getRandomArray(100);
        Arrays.sort(randomArray);
        System.out.println(Arrays.toString(randomArray));
    }

    public static int[] getRandomArray(int range) {
        int[] res = new int[range];
        int[] arr = new int[range];

        //白板编程时range取等了
        for (int i = 0; i < range; i++) {
            arr[i] = i + 1;
        }

        int end = range - 1;
        for (int i = 0; i < range; i++) {
            //白板编程时Random首字母没大写
            int index = new Random().nextInt(end + 1);
            res[i] = arr[index];
            arr[index] = arr[end];
            end--;
        }
        return res;
    }
}
