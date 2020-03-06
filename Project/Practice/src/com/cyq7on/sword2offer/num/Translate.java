package com.cyq7on.sword2offer.num;

/**
* @description
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/3/6
**/
public class Translate {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) {
            return 1;
        }
        //dp[i]表示前i个数字的翻译方法数，所以dp长度多1
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            char ch2 = s.charAt(i - 2);
            char ch1 = s.charAt(i - 1);
            if (ch2 == '1' || (ch2 == '2' && ch1 <= '5')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    //自己的解法，正确，初始值稍微麻烦点
    public int translateNum0(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) {
            return 1;
        }
        //dp[i]表示到第i个数字的翻译方法数
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int k = Integer.parseInt(s.substring(0, 2));
        if (k <= 25) {
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            k = Integer.parseInt(s.substring(i - 1,i + 1));
            //没有k>9的反例：506
            if (k <= 25 && k > 9) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
