package com.cyq7on.leetcode;

public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = chars.length - 1; i > -1; i--) {
            sum += (chars[i] - 'A' + 1) * Math.pow(26, chars.length - i -1);
        }
        return sum;
    }
}
