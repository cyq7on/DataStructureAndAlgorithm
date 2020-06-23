package com.cyq7on.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Card {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = scanner.nextInt();
        int[] temp = new int[num];
        int i = 0;
        while (i < num) {
            temp[i++] = scanner.nextInt();
        }
        exchange(temp,count);
        System.out.println(Arrays.toString(temp));
    }

    private static void exchange(int[] arr,int count) {
        if (count == 0) {
            return;
        }

        int[] temp = new int[arr.length];
        if (arr.length % 2 == 0) {
            int evenStart = arr.length / 2;
            for (int i = 0; i < evenStart; i++) {
                temp[i] = arr[i + evenStart];
                temp[i + 1] = arr[i];
            }
        }else {
            int evenStart = arr.length / 2 + 1;
            for (int i = 0; i < evenStart; i++) {
                temp[i] = arr[i];
                temp[i + 1] = arr[i + evenStart];
            }
        }
        exchange(temp,count - 1);
    }
}
