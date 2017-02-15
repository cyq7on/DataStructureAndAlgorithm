package com.cyq7on.stackandqueue;

import java.util.Stack;

/**
 * Created by cyq7on on 17-2-15.
 */
public class TwoStacksImpQueue {

    public static void main(String[] args) {
        TwoStacksImpQueue test = new TwoStacksImpQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        test.add(4);
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
    }

    private Stack<Integer> pushStack,popStack;

    public TwoStacksImpQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    public void add(int num) {
        pushStack.push(num);
    }
    public int poll() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
    public int peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }
}
