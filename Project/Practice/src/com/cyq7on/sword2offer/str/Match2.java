package com.cyq7on.sword2offer.str;

/**
 * @author cyq7on
 * @description 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/20
 **/
public class Match2 {

    private int[][] memo;

    public boolean isMatch(String s, String p) {
        if(p.length() == 0) {
            return s.length() == 0;
        }
        memo = new int[s.length() + 1][p.length() + 1];
        return match(s.toCharArray(),0,p.toCharArray(),0);
    }

    private boolean match(char[] str,int index1,char[] pattern,int index2) {

        if(memo[index1][index2] > 0) {
            return memo[index1][index2] == 1;
        }

        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if(index2 == pattern.length) {
            return index1 == str.length;
        }

        //判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean headMatch = index1 < str.length && (str[index1] == pattern[index2] || pattern[index2] == '.');
        if(index2 < pattern.length - 1 && pattern[index2 + 1] == '*') {
            //如果p的第一个元素的下一个元素是*
            //则分别对两种情况进行判断
            boolean match = match(str,index1,pattern,index2 + 2) ||
                    (headMatch && match(str,index1 + 1,pattern,index2));
            memo[index1][index2] = match ? 1 : 2;
            return match;
        }else if(headMatch) {
            //否则，如果s和p的首字符相等
            boolean match = match(str,index1 + 1,pattern,index2 + 1);
            memo[index1][index2] = match ? 1 : 2;
            return match;
        }else {
            memo[index1][index2] = 2;
            return false;
        }

    }

    public static void main(String[] args) {
        Match2 match = new Match2();
        System.out.println(match.isMatch("mississippi", "mis*is*p*."));
    }
}
