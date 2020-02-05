package com.cyq7on.practice.stackandqueue;

import java.util.Stack;

/**
 * Created by cyq7on on 17-2-17.
 */
public class StackSortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        StackSortStack stackSortStack = new StackSortStack();
        stackSortStack.sort(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private Stack<Integer> helpStack;

    public StackSortStack() {
        helpStack = new Stack<>();
    }

    public void sort(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int num = stack.pop();
            while (!helpStack.isEmpty() && num > helpStack.peek()) {
                stack.push(helpStack.pop());
            }
            helpStack.push(num);
        }
        while (!helpStack.isEmpty()) {
            stack.add(helpStack.pop());
        }
    }
}
