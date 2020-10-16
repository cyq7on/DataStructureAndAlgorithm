package com.cyq7on.practice.other;

import java.util.Arrays;
import java.util.List;

public class GuangZhuiYuan {
    public static int getGroup(List<Integer> list) {
        int count = 0;
        list.sort((o1, o2) -> o2 - o1);
        int i = 0;
        while (i < list.size()) {
            Integer integer = list.get(i);
            if (integer + i - 1 < list.size()) {
                count++;
            }
            i = integer + i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getGroup(Arrays.asList(1,3,2,3,2,2)));
        System.out.println(getGroup(Arrays.asList(2,5,3)));


        int x = 4;
        System.out.println("v is " + (x > 4 ? 99.9 : 9));
    }
}
