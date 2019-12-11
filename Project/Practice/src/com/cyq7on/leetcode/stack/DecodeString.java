package com.cyq7on.leetcode.stack;

import java.util.Stack;

/**
* @description
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
* @author cyq7on
* @create 2019/12/11
**/
public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> charStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder count = new StringBuilder();
                StringBuilder temp = new StringBuilder();
                Character character;
                while ((character = charStack.peek()) != '[') {
                    temp.append(character);
                    charStack.pop();
                }
                charStack.pop();
                while (!charStack.isEmpty() && (character = charStack.peek()) - '0' <= 9) {
                    count.append(character);
                    if (!charStack.isEmpty()) {
                        charStack.pop();
                    }
                }
                if (count.length() == 0) {
                    continue;
                }
                temp.reverse();
                count.reverse();
                boolean flag = !charStack.isEmpty();
                for (int j = 0; j < Integer.parseInt(count.toString()); j++) {
                    if (flag) {
                        for (int k = 0; k < temp.length(); k++) {
                            charStack.push(temp.charAt(k));
                        }
                    }else {
                        sb.append(temp);
                    }
                }
            } else {
                charStack.push(c);
            }
        }
        if (charStack.isEmpty()) {
            return sb.toString();
        }
        StringBuilder temp = new StringBuilder();
        while (!charStack.isEmpty()) {
            temp.append(charStack.pop());
        }
        temp.reverse();
        return sb.append(temp).toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(new DecodeString().decodeString("3[a]2[b4[F]c]"));
        System.out.println(new DecodeString().decodeString("100[leetcode]"));
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
    }
}
