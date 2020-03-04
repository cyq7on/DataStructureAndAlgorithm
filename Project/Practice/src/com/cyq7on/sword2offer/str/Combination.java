package com.cyq7on.sword2offer.str;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cyq7on
 * @description
 * 输入一个字符串，打印出该字符串中字符的所有组合。
 * @create 2020/2/29
 **/
public class Combination {
    private Set<String> result = new HashSet<>();
    private int[] visit;

    public String[] combination(String s) {
        int length = s.length();
        visit = new int[length];
        backTrack(s,new StringBuilder(length),0);
        return result.toArray(new String[0]);
    }

    private void backTrack(String s, StringBuilder track,int index) {
        if (track.length() > 0) {
            String res = track.toString();
            result.add(res);
        }
        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            track.append(ch);
            backTrack(s, track,index + 1);
            track.deleteCharAt(track.length() - 1);
            visit[i] = 0;
        }
    }



    public static void main(String[] args) {
        Combination combination = new Combination();
//        System.out.println(Arrays.toString(combination.combination("dkjphedy")));
        System.out.println(Arrays.toString(combination.combination("abc")));
//        System.out.println(Arrays.toString(combination.combination("aab")));
    }
}
