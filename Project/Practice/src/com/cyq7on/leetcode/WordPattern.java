package com.cyq7on.leetcode;

import java.io.UnsupportedEncodingException;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat fish"));
        try {
            System.out.println("山".getBytes("UTF-16").length);
            System.out.println("I".getBytes("UTF-16").length);
            System.out.println("Ia".getBytes("UTF-16").length);
            System.out.println("山".getBytes("UTF-8").length);
            System.out.println("I".getBytes("UTF-8").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public static boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (split.length != chars.length) {
            return false;
        }
        if (pattern.length() == 1) {
            return true;
        }
        for (int i = 1; i < chars.length; i++) {
            if ((chars[0] == chars[i])^(split[0].equals(split[i]))) {
                return false;
            }
        }
        return wordPattern(pattern.substring(1),str.substring(split[0].length() + 1));
    }
}
