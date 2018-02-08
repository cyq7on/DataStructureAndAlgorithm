package com.cyq7on.leetcode;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        return getString(s);
    }

    private static String getString(String s) {
        if (s.length() == 1) {
            return "1" + s;
        }
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (c != s.charAt(i)) {
                return i + "" + c + getString(s.substring(i));
            }
        }
        return s.length() + "" + c;
    }

   /* char* countAndSay(int n) {
        char c =  '1';
        if (n == 1) {
            return &c;
        }
        char* s = countAndSay(n - 1);
        return getString(s);
    }

    char getString(char* s) {
        int i;
        char c = s[0];
        if (s[0] && !s[1]) {
            return ('1' + *s);
        }

        for (int i = 1; s[i]; i++) {
            if (c != s[i]) {
                return ((i + '' + c + getString(&s[i]));
            }
        }
        return (i + '' + c);
    }*/
}
