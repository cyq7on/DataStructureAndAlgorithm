package com.cyq7on.practice.other;

import java.util.Scanner;

public class CharDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        char[] chars = split[0].toCharArray();
        char a = Character.toUpperCase(split[1].charAt(0));
        char b = Character.toUpperCase(split[2].charAt(0));

        int p1First = -1,p2First = -1;
        int p1Last = -1,p2Last = -1;
        for (int i = 0; i < chars.length; i++) {
            char ch = Character.toUpperCase(chars[i]);
            if (ch == a) {
                if (p1First == -1) {
                    p1First = i;
                }
                p1Last = i;
            }

            if (ch == b) {
                if (p2First == -1) {
                    p2First = i;
                }
                p2Last = i;
            }
        }

        if (p1Last == -1 || p2Last == -1) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.max(Math.abs(p1First - p2Last),Math.abs(p1Last - p2First)));
    }
}
