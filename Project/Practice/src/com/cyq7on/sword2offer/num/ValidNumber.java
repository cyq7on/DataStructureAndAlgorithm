package com.cyq7on.sword2offer.num;

/**
* @description
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 *  
 *
 * 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/2/21
**/
public class ValidNumber {

    //A[.[B]][e|EC] or .B[e|EC]
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int i;
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '.' || ch == 'e' || ch == 'E') {
                break;
            }
        }
        boolean a = false;
        if (i == 1) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                return false;
            }
        }else if (i > 0){
            a = true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber("t"));

    }

}
