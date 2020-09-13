package com.cyq7on.practice.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostRight {

    // 定义36进制数字
    private static final String X36 = "0123456789abcdefghijklmnopqrstuvwxyz";
    // 拿到36进制转换10进制的值键对
    private static Map<Character, Integer> thirysixToTen = createMapThirtysixToTen();
    // 定义静态进制数
    private static int BASE = 36;

    private static HashMap<Character, Integer> createMapThirtysixToTen() {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < X36.length(); i++) {
            // 0--0,... ..., Z -- 35的对应存放进去
            map.put(X36.charAt(i), i);
        }
        return map;
    }

    private static HashMap<Integer, Character> createMapTenToThirtysix() {
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < X36.length(); i++) {
            // 0--0,... ..., 35 -- Z的对应存放进去
            map.put(i, X36.charAt(i));
        }
        return map;
    }


    public static int ThirtysixToDeciaml(String pStr) {
        if (pStr.equals(""))
            return 0;
        // 目标十进制数初始化为0
        int deciaml = 0;
        // 记录次方,初始为36进制长度 -1
        int start = 0;
        int sign = 1;
        // 将36进制字符串转换成char[]
        char[] keys = pStr.toCharArray();
        if (keys[0] == '-') {
            start = 1;
            sign = -1;
        }
        int power = pStr.length() - 1 - start;

        for (int i = start; i < pStr.length(); i++) {
            // 拿到36进制对应的10进制数
            int value = thirysixToTen.get(keys[i]);
            deciaml = (int) (deciaml + value * Math.pow(BASE, power));
            // 执行完毕 次方自减
            power--;
        }
        return deciaml * sign;
    }

    private static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(numTrees(scanner.nextInt()));
        System.out.println(ThirtysixToDeciaml(scanner.nextLine()));
    }

}
