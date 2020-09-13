package com.cyq7on.practice.other;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class YuanJing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getCount(n));
    }

    private static int getCount(int n) {
        int count = 0;
        for(int i = n; i >= 5; i--) {
            int temp = i;
            while(temp % 5 == 0) {
                count++;
                temp /= 5;
            }
        }
        return count;
    }

    public boolean judge(String str) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            if (stack.isEmpty() || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                switch (ch) {
                    case '"':
                        if (stack.peek() == '"')
                            stack.pop();
                        else stack.push(ch);
                        break;
                    case ']':
                        if (stack.pop() != '[')
                            return false;
                    case '}':
                        if (stack.pop() != '{')
                            return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
