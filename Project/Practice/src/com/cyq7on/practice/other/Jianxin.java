package com.cyq7on.practice.other;

import java.util.*;

public class Jianxin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] db = s1.substring(0,s1.length() - 1).split(" ");
        int size = (int) (db.length / 0.75f + 1);
        Map<String, Integer> map = new HashMap<>(size);
        for (String s : db) {
            Integer integer = map.getOrDefault(s, 0);
            integer++;
            map.put(s, integer);
        }
        String s2 = scanner.nextLine();
        String[] input = s2.substring(0,s2.length() - 1).split(" ");

        for (String s : input) {
            Integer integer = map.getOrDefault(s, 0);
            integer++;
            map.put(s, integer);
        }
        StringBuilder sb = new StringBuilder("[");
        map.forEach((s, integer) -> {
            if (integer == 1) {
                sb.append("\"").append(s).append("\"").append(",");
            }
        });
        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        System.out.println(sb);
    }
}
