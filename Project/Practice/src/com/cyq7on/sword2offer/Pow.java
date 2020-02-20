package com.cyq7on.sword2offer;

/**
 * @author cyq7on
 * @description 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/19
 **/
public class Pow {
    public double myPow(double x, int n) {
        if (n < 0) {
            if (x == 0) {
                throw new RuntimeException("不合法的输入");
            }
            int abs = Math.abs(n);
            //处理边界情况
            if (abs < 0) {
                if (x > 0) {
                    abs = Math.abs(n + 1);
                }else {
                    abs = Math.abs(n + 2);
                }
            }
            double v = unsignedPow(x, abs);
            return 1.0 / v;
        }
        return unsignedPow(x, n);
    }

    private double unsignedPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double pow = unsignedPow(x, n >> 1);
        pow *= pow;
        //判断是否奇数
        if ((n & 1) == 1) {
            pow *= x;
        }
        return pow;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        /*System.out.println(pow.myPow(2, 10));
        System.out.println(pow.myPow(2.1, 3));
        System.out.println(pow.myPow(2, -2));*/
        System.out.println(pow.myPow(2.00000, -2147483648));
        System.out.println(pow.myPow(-1.00000, -2147483648));
    }
}
