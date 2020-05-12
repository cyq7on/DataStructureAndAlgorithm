package com.cyq7on.practice.wy;

import java.util.Scanner;

public class Main {

    /**
     * 接收两个表示9进制数的字符串，返回表示它们相加后的9进制数的字符串
     * @param num1 string字符串 第一个加数
     * @param num2 string字符串 第二个加数
     * @return string字符串
     */
    public String add (String num1, String num2) {
        // write code here
        if (num1 == null) {
            num1 = "";
        }

        if (num2 == null) {
            num2 = "";
        }
        boolean neg1 = false;
        if (num1.startsWith("-")) {
            neg1 = true;
        }
        boolean neg2 = false;
        if (num2.startsWith("-")) {
            neg2 = true;
        }
        if (!neg1 && !neg2) {
            return addPos(num1, num2);
        }else if (neg1 && neg2) {
            return "-" + addPos(num1.substring(1),num2.substring(1));
        }else {
            if (num1.startsWith("-")) {
                String t = num1;
                num1 = num2;
                num2 = t;
            }
            return addPosAndNeg(num1, num2);

        }
    }

    private String addPosAndNeg(String num1,String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.max(len1, num2.length());
        int carry = 0;
        char[] chars = new char[len];
        int i = len - 1;
        while (i >= 0) {
            int n1=0;
            if (i < len1) {
                char ch = num1.charAt(i);
                if (ch == '.') {
                    chars[i] = ch;
                    i--;
                    continue;
                }
                n1 = ch - '0';
            }
            int n2 = 0;
            if (i < len2) {
                char ch = num2.charAt(i);
                if (ch == '.') {
                    chars[i] = ch;
                    i--;
                    continue;
                }
                n2 = ch - '0';
            }
            int sum = carry + n1 - n2;
            if (sum < 0) {
                carry = sum / 9;
                sum %= 9;
            }else {
                carry = 0;
            }
            chars[i] = (char) (sum + '0');
            i--;
        }
        String s = new String(chars);
        if (carry < 0) {
            s = carry + s;
        }
        return s;
    }

    private String addPos(String num1,String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.max(len1, num2.length());
        int carry = 0;
        char[] chars = new char[len];
        int i = len - 1;
        while (i >= 0) {
            int n1=0;
            if (i < len1) {
                char ch = num1.charAt(i);
                if (ch == '.') {
                    chars[i] = ch;
                    i--;
                    continue;
                }
                n1 = ch - '0';
            }
            int n2 = 0;
            if (i < len2) {
                char ch = num2.charAt(i);
                if (ch == '.') {
                    chars[i] = ch;
                    i--;
                    continue;
                }
                n2 = ch - '0';
            }
            int sum = carry + n1 + n2;
            if (sum >= 9) {
                carry = sum / 9;
                sum %= 9;
            }else {
                carry = 0;
            }
            chars[i] = (char) (sum + '0');
            i--;
        }
        String s = new String(chars);
        if (carry > 0) {
            s = carry + s;
        }
        return s;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.add("0.8","-0.1"));
        System.out.println(main.add("-0.8","-0.1"));
        System.out.println(main.add("0.8","0.1"));
        System.out.println(main.add("1.28","1.71"));
        System.out.println(main.add("","15.0"));
        System.out.println(main.add("25","15"));
        System.out.println(main.add("1.24","8.65"));
        System.out.println(main.add("1.24","8.55"));
        System.out.println(main.add("1.24","8.6"));
        System.out.println(main.add("1.24","8.7"));
        System.out.println(main.add("1.244444444444444444444444444","8"));
        System.out.println(main.add("1.2","8"));
        System.out.println(main.add("1","8"));
        System.out.println(main.add("0.0","8"));
        System.out.println(main.add("1.0","8"));
    }

    void test() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    void test1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i--){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }
}
