package com.cyq7on.practice.hw;

import java.util.Scanner;

public class Str {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int maxLen = in.nextInt();
        output(0,maxLen,line);
    }

    private static void output(int start, int maxLen, String s) {
        if (start >= s.length()) {
            return;
        }
        int length = s.length() - start;
        if (length <= maxLen) {
            System.out.print("{");
            System.out.print(s.substring(start));
            System.out.println("}");
        }else {
            System.out.print("{");
            char[] chars = s.toCharArray();
            int i;
            for (i = start; i < maxLen - 1 + start; i++) {
                System.out.print(chars[i]);
            }
            int newStart ;
            //判断行尾
            if (chars[i] != ' ') {
                if (chars[i - 1] == ' ') {
                    newStart = i;
                }else if (chars[i + 1] == ' ') {
                    System.out.print(chars[i]);
                    newStart = i + 2;
                }else {
                    System.out.print("-");
                    newStart = i;
                }

            }else {
                //结尾是下一个单词首字母
                /*if (chars[i - 1] == ' ') {
                    newStart = i;
                }else {
                    newStart = i + 1;
                }*/

                newStart = i + 1;
            }
            System.out.println("}");
            output(newStart,maxLen,s);
        }
    }

}
