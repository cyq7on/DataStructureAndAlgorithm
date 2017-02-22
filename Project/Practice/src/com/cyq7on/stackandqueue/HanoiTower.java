package com.cyq7on.stackandqueue;

import java.util.Stack;

/**
 * Created by cyq7on on 17-2-17.
 */
public class HanoiTower {

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        int step = hanoiTower.move(4);
        System.out.println("It will move " + step + " steps.");
    }

    private Action action = Action.No;
    private enum Action {
        No, LtoM, MtoL, MtoR, RtoM
    }

    public int move(int num) {
        int step = 0;

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> midStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        for (int i = num; i > 0; i--) {
            leftStack.push(i);
        }
        while (rightStack.size() < num) {
            step += fromStackTotoStack(Action.MtoL, Action.LtoM, leftStack, midStack, "left", "mid");
            step += fromStackTotoStack(Action.LtoM, Action.MtoL, midStack, leftStack, "mid", "left");
            step += fromStackTotoStack(Action.RtoM, Action.MtoR, midStack, rightStack, "mid", "right");
            step += fromStackTotoStack(Action.MtoR, Action.RtoM, rightStack, midStack, "right", "mid");
        }
        return step;
    }

    public int fromStackTotoStack(Action preNoAction, Action nowAction, Stack<Integer> fromStack,
                                  Stack<Integer> toStack, String from, String to) {
        if (action != preNoAction && !fromStack.isEmpty()) {
            if (toStack.isEmpty() || fromStack.peek() < toStack.peek()) {
                toStack.push(fromStack.pop());
                action = nowAction;
                System.out.println("Move " + toStack.peek() + " from " + from + " to " + to);
                return 1;
            }
        }
        return 0;
    }
}
