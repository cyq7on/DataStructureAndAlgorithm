package com.cyq7on.leetcode.str;

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        //纯粹利用其contains方法优化时间复杂度
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> last = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            last.put(chars[i],i);
        }

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!set.contains(ch)) {
                while (!stack.isEmpty() && stack.peekLast() > ch && last.get(stack.peekLast()) > i) {
                    Character character = stack.removeLast();
                    set.remove(character);
                }
                stack.addLast(ch);
                set.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters letters = new RemoveDuplicateLetters();
        System.out.println(letters.removeDuplicateLetters("bcabc"));
    }
}
