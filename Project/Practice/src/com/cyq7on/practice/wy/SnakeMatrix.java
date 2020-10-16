package com.cyq7on.practice.wy;

public final class SnakeMatrix {
    public static void main(String[] args) {
        int a = 7;
        int b = 5;
        a = b - a +(b = a);
        System.out.println(a);

        int i = 121;
        System.out.println((i >> 3 & (i & 0x07)));
        System.out.println(Math.round(32.5));
        System.out.println(Math.round(-32.5));

        Integer f1 = 100, f2= 100, f3= 200, f4 = 200;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

    }
}
