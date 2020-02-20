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
public class Match {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return match(s, 0, p, 0);
    }

    private boolean match(String s, int index1, String p, int index2) {
        if (index1 == s.length() && index2 == p.length()) {
            return true;
        }

        //模式已经到最后
        if (index1 != s.length() && index2 == p.length()) {
            return false;
        }
        boolean equal = index1 < s.length() && (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '.');
        if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
            if (equal) {
                //当前字符相等，则：
                //1、s跳到下一个字符，模式跳过下一个*号继续匹配
                //2、s跳到下一个字符，模式保持不动继续匹配，因为*可以匹配多位
                //3、s保持，模式跳过下一个*号继续匹配。这种情况从贪心角度来看是不明智的，
                //即放弃了此次相等
                return match(s, index1 + 1, p, index2 + 2)
                        || match(s, index1 + 1, p, index2)
                        || match(s, index1, p, index2 + 2);
            } else {
                //当前字符不相等，下一个*号就没有作用了，模式跳过下一个*号继续匹配
                return match(s, index1, p, index2 + 2);
            }
        }

        if (equal) {
            return match(s, index1 + 1, p, index2 + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        Match match = new Match();
        System.out.println(match.isMatch("ab", ".*c"));
        System.out.println(match.isMatch("aa", "a"));
        System.out.println(match.isMatch("aa", "a*"));
        System.out.println(match.isMatch("aa", ".*"));
        System.out.println(match.isMatch("aab", "c*a*b"));
        System.out.println(match.isMatch("mississippi", "mis*is*p*."));
    }
}
