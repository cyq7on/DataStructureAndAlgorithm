package com.cyq7on.practice.stackandqueue;

import java.util.Stack;

/**
 * Created by cyq7on on 17-2-16.
 */
public class ReverseStackUsingRecursion {

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        ReverseStackUsingRecursion reverseStackUsingRecursion = new ReverseStackUsingRecursion();
        reverseStackUsingRecursion.reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }

    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int last = getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }
}
