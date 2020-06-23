package com.cyq7on.leetcode.str;

/**
* @description
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/6/23
**/
public class AddBinary {
    public String addBinary(String a, String b) {
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        StringBuilder res = new StringBuilder(Math.max(index1, index2) + 2);
        char[] chars0 = a.toCharArray();
        char[] chars1 = b.toCharArray();
        int carry = 0;
        while (index1 >= 0 && index2 >= 0) {
            int sum = chars0[index1--] - '0' + chars1[index2--] - '0' + carry;
            carry = sum / 2;
            res.append(sum % 2);
        }

        while (index1 >= 0) {
            int sum = chars0[index1--] - '0' + carry;
            carry = sum / 2;
            res.append(sum % 2);
        }

        while (index2 >= 0) {
            int sum = chars1[index2--] - '0' + carry;
            carry = sum / 2;
            res.append(sum % 2);
        }

        if (carry > 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
