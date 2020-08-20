package com.cyq7on.practice;

import java.util.Scanner;

public class CompressString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() <= 1) {
            System.out.println(s);
            return;
        }
        char[] chars = s.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            }else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(chars[i]);
                count = 1;
            }
        }
        if (count > 1) {
            sb.append(count);
        }
        System.out.println(sb);
    }



}




