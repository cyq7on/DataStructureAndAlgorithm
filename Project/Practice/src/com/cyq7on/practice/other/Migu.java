package com.cyq7on.practice.other;

import java.util.Scanner;

public class Migu {
    public static void main(String[] args) {
        System.out.println(Season.SPTRING.ordinal());
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int res = 0;
        for (String s : split) {
            res ^= Integer.valueOf(s);
        }
        System.out.println(res);
    }

    enum Season{
        WINTER,SPTRING,SUMMER,FAIL
    }
}
