package com.cyq7on.sword2offer.str;

import java.util.*;

/**
 * @author cyq7on
 * @description 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/29
 **/
public class Permutation {
    private Set<String> result = new HashSet<>();
    private int[] visit;

    public String[] permutation(String s) {
        int length = s.length();
        visit = new int[length];
//        backTrack(s,"");
        backTrack(s,new StringBuilder(length));
        return result.toArray(new String[0]);
    }

    //这个居然更快
    private void backTrack(String s, StringBuilder track) {
        if (track.length() == s.length()) {
            String res = track.toString();
            result.add(res);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            track.append(ch);
            backTrack(s, track);
            track.deleteCharAt(track.length() - 1);
            visit[i] = 0;
        }
    }

    private void backTrack(String s, String track) {
        if (track.length() == s.length()) {
            result.add(track);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            //瓶颈应该在这里，字符串+
            backTrack(s, track + ch);
            visit[i] = 0;
        }
    }


    public static void main(String[] args) {
        Permutation permutation = new Permutation();
//        System.out.println(Arrays.toString(combination.combination("dkjphedy")));
//        System.out.println(Arrays.toString(combination.combination("abc")));
        System.out.println(Arrays.toString(permutation.permutation("aab")));
    }
}
