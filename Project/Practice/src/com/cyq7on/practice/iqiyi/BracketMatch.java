package com.cyq7on.practice.iqiyi;

import java.util.*;
import java.util.Scanner;

public class BracketMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (isValid(line)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}

