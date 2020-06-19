package com.cyq7on.leetcode.quene;

import java.util.*;

/**
* @description
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
* @author cyq7on
* @create 2019/12/13
**/
public class TaskSchduler {
    
    public int leastInterval(char[] tasks, int n) {
        int count = 0;
        List<Character> list = new ArrayList<>(tasks.length);
        Map<Character, Integer> map = new HashMap<>(tasks.length);
        for (Character character : tasks) {
        }
        while (list.isEmpty()) {
            for (Character character : list) {

            }
        }
        return 0;
    }
}
