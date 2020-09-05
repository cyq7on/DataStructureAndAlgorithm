package com.cyq7on.practice.other;


import java.util.ArrayList;
import java.util.Comparator;

public class Sougou {
    private long count;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回生成的新密码个数
     *
     * @param password string字符串 密码的数组字符串（长度小于50），例如 12345
     * @return long长整型
     */
    public long getPasswordCount(String password) {
        // write code here
        count = 0;
        char[] chars = password.toCharArray();
        char[] pwd = new char[chars.length];
        for (int i = 0; i <= 9; i++) {
            pwd[0] = (char) (i + '0');
            dfs(chars, 1, pwd);
        }
        return count;
    }

    private void dfs(char[] chars, int start, char[] pwd) {
        if (start == chars.length) {
            boolean same = true;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != pwd[i]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                count++;
            }
//            System.out.println(Arrays.toString(pwd));
            return;
        }

        int val = chars[start] - '0' + pwd[start - 1] - '0';
        if (val % 2 == 0) {
            pwd[start] = (char) (val / 2 + '0');
            dfs(chars, start + 1, pwd);
//            pwd[start] = 0;
        } else {
            pwd[start] = (char) (val / 2 + '0');
            dfs(chars, start + 1, pwd);
            pwd[start] = (char) (val / 2 + 1 + '0');
            dfs(chars, start + 1, pwd);

//            pwd[start] = 0;
        }
    }

    public int getHouses(int t, int[] xa) {
        // write code here
        ArrayList<double[]> res = new ArrayList<>();
        for (int i = 0; i < xa.length; i += 2) {
            double left = xa[i] - xa[i + 1] / 2.0;
            double right = xa[i] + xa[i + 1] / 2.0;
            res.add(new double[]{left, right});
        }
        res.sort(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return o1[0] == o2[0] ? (int) (o1[1] - o2[1]) : (int) (o1[0] - o2[0]);
            }
        });
        int count = 2;
        for (int i = 1; i < res.size(); i++) {
            double[] left = res.get(i - 1);
            double[] right = res.get(i);
            int val = (int) (right[0] - left[1]);
            if (val == t) {
                count += 1;
            } else if (val > t) {
                count += 2;
            }
        }
        return count;
    }

    private int res = 0;
    public int numberofprize (int a, int b, int c) {
        // write code here
        int min = Math.min(Math.min(a, b), c);
        res += min;
        a -= min;
        b -= min;
        c -= min;
        if (a != 0 && b != 0) {
            int[] temp = getRes(a, b);
            a = temp[0];
            b = temp[1];
        } else if (a != 0 && c != 0) {
            int[] temp = getRes(a, c);
            a = temp[0];
            c = temp[1];
        } else if (c != 0 && b != 0) {
            int[] temp = getRes(c, b);
            c = temp[0];
            b = temp[1];
        }
        int max = Math.max(Math.max(a, b), c);
        return res + max / 5;
    }

    public int[] getRes(int x, int y) {
        int val = Math.min(x, y);
        x -= val;
        y -= val;
        if (val % 2 == 1){
            res++;
            if (x >= 3) {
                x -= 3;
            } else if (y >= 3) {
                y -= 3;
            } else res--;
        }
        res += val / 2;
        return new int[]{x, y};
    }



    public static void main(String[] args) {
        Sougou sougou = new Sougou();
        System.out.println(sougou.getPasswordCount("123"));
        System.out.println(sougou.getPasswordCount("12345"));
        System.out.println(sougou.getPasswordCount("09"));
        System.out.println(sougou.getPasswordCount("3"));
    }
}
