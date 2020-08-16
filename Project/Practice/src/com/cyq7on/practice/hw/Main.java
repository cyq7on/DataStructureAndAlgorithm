package com.cyq7on.practice.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(getString("bcabc"));
    }

    private static String getString(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);
            if (integer == null) {
                map.put(chars[i], i);
            } else {

                //保留的是以前的
                String s1 = new StringBuilder(s).deleteCharAt(i).toString();
                //删除old
                String s2 = new StringBuilder(s).deleteCharAt(integer).toString();
                //保留当前更小
                if (s2.compareTo(s1) < 0) {
                    map.put(chars[i], i);
//                    count++;
//                    s = s1;
                } else {
//                    s = s2;
                }
            }
        }

//        StringBuilder sb = new StringBuilder();
        char[] chars1 = new char[map.size()];
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);
            if (integer == i) {
                chars1[k++] = chars[i];
            }
        }

        return new String(chars1);
    }

    private static boolean isValid(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        while (num > 0) {
            int temp = num % 10;
            Integer count = map.getOrDefault(temp, 0);
            count++;
            map.put(temp, count);

            num /= 10;
        }
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            if (map.get(i) == 2) {
                return true;
            }
        }
        return false;
    }
}

