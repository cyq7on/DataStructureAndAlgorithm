package com.cyq7on.practice.other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class StringFind {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String s = scanner.nextLine();
        LinkedList<Character> linkedList = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        int start = 0,right = 0;
        int len = 0;
        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                right++;
                continue;
            }
            if (set.size() < 2) {
                set.add(ch);
                linkedList.addLast(ch);
                right++;
            }else if (set.contains(ch)) {
                right++;
            }else {
                len = Math.max(len, right - start);
                String temp = new String(chars, start, right - start);
                if (res.length() < temp.length()) {
                    res = temp;
                }
                Character character = linkedList.pollFirst();
                start = s.indexOf(String.valueOf(linkedList.peekLast()));
                set.remove(character);

                set.add(ch);
                linkedList.addLast(ch);
            }
        }
        System.out.println(res);
    }
}
