package com.cyq7on.practice.other;

import java.util.*;

public class H3C {
    public static void main(String[] args) {
        Object[][] b = {{new Object(),}, {new Object(), new Object()}};
        System.out.println(b[0].length);
        System.out.println(b[1].length);

        int[] arrayInt1 = {0, 0};
        int[] arrayInt2 = {0, 0};
        Object[] arrayObj1 = {new Object(), new Object()};
        Object[] arrayObj2 = {new Object(), new Object()};
        System.out.println(Arrays.equals(arrayObj1, arrayObj2));
        System.out.println(arrayObj1.equals(arrayObj2));
        System.out.println(arrayInt1.equals(arrayInt2));
        System.out.println(Arrays.equals(arrayInt1, arrayInt2));
        System.out.println(test());

        String textString = new String("java");
        StringBuffer textBuffer = new StringBuffer("java");
        stringReplace(textString);
        bufferReplace(textBuffer);
        System.out.println(textString + textBuffer);

        System.out.println(character_auto_complete("s"));
        System.out.println(MidFactor(16));
        System.out.println(MidFactor(12));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param val long长整型
     * @return long长整型
     */
    public static long MidFactor(long val) {
        // write code here
        List<Long> list = new ArrayList<>();

        for (long i = 1; i <= (val + 1) / 2; i++) {
            if (val % i == 0) {
                list.add(val / i);
                list.add(i);
            }
        }
        list.sort(Long::compareTo);
        return list.get((list.size() - 1) / 2);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 请实现一个输入联想功能
     *
     * @param str string字符串 查找字符串
     * @return string字符串
     */
    public static String character_auto_complete(String str) {
        // write code here
        String[] arr = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday".split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (s.startsWith(str)) {
                sb.append(s).append(" ");
            }
        }

        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append("No match");
        }
        return sb.toString();
    }

    public static void stringReplace(String text) {
        text = text.replace("j", "l");
    }

    public static void bufferReplace(StringBuffer text) {
        text = text.append("java");
    }


    static int test() {
        int x = 1;
        try {
            return x++;
        } finally {
            ++x;
        }


    }
}
