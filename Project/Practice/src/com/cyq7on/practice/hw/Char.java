package com.cyq7on.practice.hw;

import java.util.Scanner;

public class Char {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] split = line.split(" ");
        for (int j = 0; j < split.length; j++) {
            String s = split[j];
            char[] chars = s.toCharArray();
            boolean b = true;
            for (int i = 0; i < chars.length; i++) {
                if (check(chars[i])) {
                    if (b) {
                        if (i == 0) {
                            System.out.print(Character.toUpperCase(chars[0]));
                        }else {
                            System.out.print(Character.toLowerCase(chars[i]));
                        }
                        b = false;
                    }else {
                        b = true;
                    }
                }else {
                    if (i == 0) {
                        System.out.print(Character.toUpperCase(chars[0]));
                    }else {
                        System.out.print(chars[i]);
                    }
                }
            }

            if (j < split.length - 1) {
                System.out.print(" ");
            }
        }
    }

    private static boolean check(Character character) {
        return character == 'A' || character == 'E'||character == 'I' || character == 'O'||character == 'U' ;
    }
}
