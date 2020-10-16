package com.cyq7on.practice.other;

public class Father {
    private String baseName = "father";

    public Father() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Son extends Father {
        private String baseName = "son";

        public void callName() {
            System.out.println(baseName);
        }

    }
    public static void main(String[] args) {
        Father f = new Son();
    }
}

