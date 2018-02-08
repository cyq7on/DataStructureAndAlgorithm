package com.cyq7on.leetcode;

public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","atbcd"));
    }

    public static char findTheDifference(String s, String t) {
        int sub = 0 ;
        for (int i = 0; i < s.length(); i++) {
            sub += t.charAt(i) -  s.charAt(i);
        }
        int c = t.charAt(t.length() - 1) - '0';
        sub += c;
        return (char) (sub + '0');
    }
}
