package com.cyq7on.leetcode.stack;


import java.util.Stack;

/**
 * @author cyq7on
 * @description Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * @create 2019/12/11
 **/
public class RemoveAllAdjacentDuplicatesInString {


    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        int size = stack.size();
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[size - i - 1] = stack.pop();
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString duplicatesInString = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(duplicatesInString.removeDuplicates("abbaca"));
    }
}
