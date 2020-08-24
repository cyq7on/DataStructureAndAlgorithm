package com.cyq7on.practice.iqiyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isCross(s) ? "True" : "False");
       /* int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            int temp = n / 5;
            count += temp;
            n = temp;
        }
        System.out.println(count);*/

    }

    private static boolean isCross(String s) {
        Set<String> set = new HashSet<>();
        set.add("00");
        char[] chars = s.toCharArray();
        int x = 0,y = 0;
        for (char ch : chars) {
            switch (ch) {
                case 'N':
                    y--;
                    break;
                case 'S':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                default:
                    x--;
                    break;
            }
            String pos = x + String.valueOf(y);
            if (set.contains(pos)) {
                return true;
            }else {
                set.add(pos);
            }
        }
        return false;
    }
}
