package com.cyq7on.practice.stackandqueue;

import java.util.Stack;

/**
 * Created by cyq7on on 17-2-15.
 */
public class GetMinStack {
    public static void main(String []args) {
        GetMinStack1 stack1 = new GetMinStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());
        System.out.println("=============");
        GetMinStack2 stack2 = new GetMinStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }

    static class GetMinStack1 {
        private Stack<Integer> dataStack,minStack;

        public GetMinStack1() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int num) {
            dataStack.push(num);
            if (minStack.isEmpty() || getMin() >= num) {
                minStack.push(num);
            }
        }

        public int pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            int val = dataStack.pop();
            if (val == getMin()) {
                minStack.pop();
            }
            return val;
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return minStack.peek();
        }
    }

    static class GetMinStack2 {
        private Stack<Integer> dataStack,minStack;

        public GetMinStack2() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int num) {
            dataStack.push(num);
            if (minStack.isEmpty()) {
                minStack.push(num);
                return;
            }
            int min = getMin();
            if (min >= num) {
                minStack.push(num);
            }else {
                minStack.push(min);
            }
        }

        public int pop() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return minStack.pop();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return minStack.peek();
        }
    }

}
