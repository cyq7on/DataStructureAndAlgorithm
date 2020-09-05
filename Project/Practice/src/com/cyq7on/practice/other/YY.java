package com.cyq7on.practice.other;


import java.util.ArrayList;
import java.util.List;

public class YY {

    /**
     * 找到比输入的整数大的下一个水仙花数
     * @param n int整型 输入的整数
     * @return long长整型
     */
    public long nextNarcissisticNumber (int n) {
        // write code here

        long num = n;
        while(true) {
            num = num + 1;
            long temp = num;
            int pow = 0;
            List<Long> list = new ArrayList<>();
            while (num > 0) {
                list.add(num % 10);
                num /= 10;
                pow++;
            }
            num = temp;
            double res = 0;
            for (Long i : list) {
                res += Math.pow(i, pow);
            }
            if (res == num) {
                return num;
            }
        }
    }


    public static void main(String[] args) {

    }

}
