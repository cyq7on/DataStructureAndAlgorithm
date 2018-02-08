package com.cyq7on.leetcode;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i++) {
            int length = arr[i].length();
            if (length > 0) {
                return length;
            }
        }
        return 0;
    }
}
