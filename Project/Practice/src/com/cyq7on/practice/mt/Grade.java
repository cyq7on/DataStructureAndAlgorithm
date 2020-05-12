package com.cyq7on.practice.mt;

import java.util.*;

public class Grade {

    public static int getNum(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        //外层是列
        for (int i = 0; i < arr[0].length; i++) {
            int best = arr[0][i];
            List<Integer> list = new ArrayList<>();
            list.add(0);
            for (int j = 1; j < arr.length; j++) {
                if (arr[j][i] > best) {
                    list.clear();
                    list.add(j);
                    best = arr[j][i];
                } else if (arr[j][i] == best) {
                    list.add(j);
                }
            }
            set.addAll(list);
        }
        return set.size();
    }

    public static void main(String[] args) {
        /*int[][] arr = new int[][]{{28, 35, 38, 10, 19},
                {4, 76, 72, 38, 86},
                {96, 80, 81, 17, 10},
                {70, 64, 86, 85, 10},
                {1, 93, 9, 34, 41},
        };
        System.out.println(getNum(arr));*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(getNum(arr));
    }
}
