package com.cyq7on.practice.mt;

import java.util.*;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        List<Bean> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Bean(scanner.nextInt(), scanner.nextInt()));
        }
        Comparator<Bean> c1 = new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                int val = o1.pa - o2.pa;
                if (val == 0) {
                    return o2.pb - o1.pb;
                }
                return val;
            }
        };

        Comparator<Bean> c2 = new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                return o1.pb - o2.pb;
            }
        };
        int max = Math.max(getMax(a, b, list,c1,c2),getMax(a,b,list,c2,c1));
        System.out.println(max);
    }

    private static int getMax(int a, int b, List<Bean> list,Comparator<Bean> c1,Comparator<Bean> c2) {
        int max = 0;
        list.sort(c1);
        for (int i = list.size() - 1; i >= 0 && a > 0; i--) {
            a--;
            max += list.remove(i).pa;
        }

        list.sort(c2);

        for (int i = list.size() - 1; i >= 0 && b > 0; i--) {
            b--;
            max += list.remove(i).pb;
        }
        return max;
    }

    static class Bean {
        public int pa;
        public int pb;

        public Bean(int pa, int pb) {
            this.pa = pa;
            this.pb = pb;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "pa=" + pa +
                    ", pb=" + pb +
                    '}';
        }
    }
}
