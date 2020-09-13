package com.cyq7on.practice.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NumberBaseUtil {

    public static void main(String[] args) {
//        long number = NumberBaseUtil.toDecimal("zzzzzzzzzzzzz", 36);
//        long number = NumberBaseUtil.toDecimal("-sgsf", 36);
        long number = NumberBaseUtil.toDecimal("&avd1", 36);
        System.out.println(number);
    }

    // number字符数组
    public static final char[] NUMBER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 输入任意进制转化为10进制
     * @param value 数值
     * @param numberBase 进制 2~36
     * @return long
     */
    public static long toDecimal(String value, int numberBase) {
        //  将数值中开头的0去掉并全部转成大写
        value = value.replaceAll("^(0+)", "").toUpperCase();
        // 初始化map，将字符数组中的按索引存入map，字符相当于key， value相当于十进制的值
        int LEN = NUMBER.length;
        Map<Character, Integer> numberMap = new HashMap<>(LEN);
        for (int i = 0; i < LEN; i++) {
            numberMap.put(NUMBER[i], i);
        }

        // 数值转为字符数组
        char[] sh = value.toCharArray();
        int start = 0;
        int sign = 1;
        // 将36进制字符串转换成char[]
        if (sh[0] == '-') {
            start = 1;
            sign = -1;
        }
        int len = sh.length - start;
        // 位数
        int n = 0;
        long sum = 0;
        for (int i = start; i < sh.length; i++) {
            // 从后位往前加
            // 根据公式 S = x ** y * z （x代表进制，y代表位数，z代表该位上的值）
            Integer integer = numberMap.get(sh[i]);
            if (integer == null) {
                return 0;
            }
            sum += integer * Math.pow(numberBase, len - (n++) - 1);
        }
        return sum * sign;
    }


    /**
     * 10进制转任意进制
     * @param value 10进制数值
     * @param base 目标进制
     * @return java.lang.String
     * @Author xiangyuan.liu
     * @Title toOtherBase
     */
    public static String toOtherBase(long value, int base) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while (value != 0) {
            stack.push(NUMBER[(int) (value % base)]);
            value /= base;
        }
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }
}

