package com.cyq7on.practice.other;

import java.util.*;

public class XunLei {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();
        Set<String> set1 = new TreeSet<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            map.put(split[0], split[1]);
            set.add(split[0]);
            set1.add(split[1]);
        }
        String fir = "";
        for (String s : set1) {
            set.remove(s);
        }
        for (String s : set)
            fir = s;
        while (map.containsKey(fir)) {
            System.out.println(fir);
            fir = map.get(fir);
        }
        System.out.println(fir);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 演示队列功能。将input中的int数值依次全部push_back到队列中，然后逐个将队列中的元素pop_front出来放到一个作为返回值的vector
     *
     * @param input int整型一维数组 输入序列
     * @param n     int整型 队列容量
     * @return int整型一维数组
     */
    public int[] test_queue(int[] input, int n) {
        // write code here
        if (n > input.length) {
            n = input.length;
        }
        int[] arr = new int[n];
        System.arraycopy(input, 0, arr, 0, n);
        return arr;
    }
}
