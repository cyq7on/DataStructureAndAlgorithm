package com.cyq7on.practice.other;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int left = 0,right = chars.length - 1;
        while (left < right) {
            while (!Character.isLetter(chars[left])) {
                left++;
            }
            while (!Character.isLetter(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        System.out.println(new String(chars));
    }

}
