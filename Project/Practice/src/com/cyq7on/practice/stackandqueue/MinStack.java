package com.cyq7on.practice.stackandqueue;

import java.util.LinkedList;
import java.util.Scanner;

public class MinStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        MinStack stack = new MinStack();
        while(count--!=0){
            String[] arr = scanner.nextLine().split(" ");
            int value=0;
            if(arr.length>1){
                value = Integer.parseInt(arr[1]);
            }

            if(arr[0].equals("push")){
                stack.push(value);
            }else if(arr[0].equals("getMin")){

                System.out.println(stack.getMin());
            }else if(arr[0].equals("pop")){
                stack.pop();
            }else if(arr[0].equals("top")){

                System.out.println(stack.top());
            }

        }


    }
}

