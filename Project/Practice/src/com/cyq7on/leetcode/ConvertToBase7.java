package com.cyq7on.leetcode;

public class ConvertToBase7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
    public static String convertToBase7(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isPos = true;
        if (num < 0) {
            isPos = false;
            num = Math.abs(num);
        }
        while (num >= 7) {
            stringBuilder.append(num % 7);
            num = num / 7;
        }
        stringBuilder.append(num);
        stringBuilder.reverse();
        if (isPos) {
            return stringBuilder.toString();
        }
        return "-" + stringBuilder.toString();
    }
}
