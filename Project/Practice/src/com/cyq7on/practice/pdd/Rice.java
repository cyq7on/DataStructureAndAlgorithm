package com.cyq7on.practice.pdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Rice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int T = scanner.nextInt();


        List<Bean> list1 = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list1.add(new Bean(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(list1);

        List<Bean> list2 = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            list2.add(new Bean(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(list2);

        if (T == 0) {
            System.out.println(0);
            return;
        }

        Bean bean1 = list1.get(0);
        Bean bean2 = list2.get(0);
        if (bean1.val + bean2.val < T) {
            System.out.println(-1);
            return;
        }

        int res = Integer.MAX_VALUE;
        if (bean1.val >= T) {
            res = Math.min(bean1.hot, res);
            for (int i = 1; i < N; i++) {
                Bean bean = list1.get(i);
                if (bean.val >= T) {
                    res = Math.min(bean.hot, res);
                } else {
                    break;
                }
            }
//            System.out.println(res);
//            return;
        }

        if (bean2.val >= T) {
            res = Math.min(bean2.hot, res);
            for (int i = 1; i < M; i++) {
                Bean bean = list2.get(i);
                if (bean.val >= T) {
                    res = Math.min(bean.hot, res);
                } else {
                    break;
                }
            }
//            System.out.println(res);
//            return;
        }

//        if (res != -1) {
//            System.out.println(res);
//            return;
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = list1.get(i).val + list2.get(j).val;
                if (val >= T) {
                    res = Math.min(list1.get(i).hot + list2.get(j).hot, res);
                }
            }
        }
        System.out.println(res);
    }

    static class Bean implements Comparable {
        public int hot;
        public int val;

        public Bean(int hot, int val) {
            this.hot = hot;
            this.val = val;
        }

        @Override
        public int compareTo(Object o) {
            Bean bean = (Bean) o;
            if (bean.val > val) {
                return 1;
            } else if (bean.val == val) {
                return hot - bean.hot;
            }
            return -1;
        }
    }
}
