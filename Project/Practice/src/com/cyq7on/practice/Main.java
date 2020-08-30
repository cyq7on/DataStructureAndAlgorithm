package com.cyq7on.practice;

import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a1 = scanner.nextLine();
        String a2 = scanner.nextLine();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (String s : a1.split(" ")) {
            Integer val = Integer.valueOf(s);
            list1.add(val);
        }
        for (String s : a2.split(" ")) {
            Integer val = Integer.valueOf(s);
            list2.add(val);
        }
        if (list1.size() == 1) {
            System.out.println("-1");
        } else {
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < list1.size(); i++) {
                for (int j = i + 1; j < list2.size(); j++) {
                    minVal = Math.min(minVal, list1.get(i) + list2.get(j));
                }
            }
            System.out.println(minVal);
        }
    }
}

