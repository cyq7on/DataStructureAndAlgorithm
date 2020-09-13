package com.cyq7on.practice.other;


public class Codility {
    public String solution(int N) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder(N);
        if (N % 2 == 0) {
            for (int i = 0; i < N - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        }else {
            for (int i = 0; i < N; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}
