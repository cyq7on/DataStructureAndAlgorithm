package com.cyq7on.practice.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Yitu {
    static class Bean {
        int val, p;

        public Bean(int val, int p) {
            this.val = val;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K1 = scanner.nextInt();
        int K2 = scanner.nextInt();

        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int Z = scanner.nextInt();
        List<Bean> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(new Bean(scanner.nextInt() * 17 * 29 + scanner.nextInt() * 29 + scanner.nextInt(), scanner.nextInt()));
        }
        if (K1 < K2) {
            System.out.println("YES");
            System.out.println(X + " " + Y + " " + Z);
            return;
        }
        list.sort(new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                if (o1.val == o2.val) {
                    return o1.p - o2.p;
                }
                return o1.val - o2.val;
            }
        });
        int total = X * 17 * 29 + Y * 29 + Z;


        for (int i = 0; i < list.size(); i++) {
            Bean bean = list.get(i);
            if (bean.val > total) {
                continue;
            }
            if (bean.p + K2 > K1) {
                System.out.println("YES");
                total -= bean.val;
                int x = total / (17 * 29);
                int y = (total % (17 * 29)) / 29;
                int z = (total % (17 * 29)) % 29;
                System.out.println(x + " " + y + " " + z);
                return;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Bean bean = list.get(i);
            if (bean.val > total) {
                continue;
            }
            total -= bean.val;
            K2 += bean.p;
        }

        if (K2 > K1) {
            System.out.println("YES");
            int x = total / (17 * 29);
            int y = (total % (17 * 29)) / 29;
            int z = (total % (17 * 29)) % 29;
            System.out.println(x + " " + y + " " + z);
            return;
        }

        System.out.println("NO");
//        for (int i = list.size() - 1; i >= 0; i--) {
//
//        }
    }

}
