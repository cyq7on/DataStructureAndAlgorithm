package com.cyq7on.leetcode.str;



/**
* @description
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/3/13
**/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(),n2 = text2.length();
        //dp[i][j]为text1前i个字符和text2前j个字符的lcs
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n1][n2];
    }

    //只能找出其中一个，找出所有使用回溯：https://blog.csdn.net/tham_/article/details/48718587
    public String getLongestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(),n2 = text2.length();
        //dp[i][j]为text1前i个字符和text2前j个字符的lcs
        int[][] dp = new int[n1 + 1][n2 + 1];
        StringBuilder sb = new StringBuilder(Math.min(n1,n2));
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (sb.length() < dp[i][j]) {
                        sb.append(text1.charAt(i - 1));
                    }
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return sb.toString();
    }


    //最长公共子字符串
    public int longestCommonStr(String text1, String text2) {
        int n1 = text1.length(),n2 = text2.length();
        //dp[i][j]为text1前i个字符和text2前j个字符的lcs
        int[][] dp = new int[n1 + 1][n2 + 1];
        int max = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    //最长公共子字符串
    public String getLongestCommonStr(String text1, String text2) {
        int n1 = text1.length(),n2 = text2.length();
        //dp[i][j]为text1前i个字符和text2前j个字符的lcs
        int[][] dp = new int[n1 + 1][n2 + 1];
        int max = 0;
        int right = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                if (max < dp[i][j]) {
                    right = i;
                    max = dp[i][j];
                }
//                max = Math.max(max,dp[i][j]);
            }
        }
        return text1.substring(right - max,right);
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        /*System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde","ace"));
        System.out.println(longestCommonSubsequence.getLongestCommonSubsequence("abcde","ace"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde","aced"));
        System.out.println(longestCommonSubsequence.getLongestCommonSubsequence("abcde","aced"));
        System.out.println(longestCommonSubsequence.getLongestCommonSubsequence("bcde","aced"));
        System.out.println(longestCommonSubsequence.getLongestCommonSubsequence("abc","abc"));*/


//        System.out.println(longestCommonSubsequence.getLongestCommonStr("abcde","ace"));
//        System.out.println(longestCommonSubsequence.getLongestCommonStr("bcde","ace"));
        System.out.println(longestCommonSubsequence.getLongestCommonStr("abc","abc"));
        System.out.println(longestCommonSubsequence.getLongestCommonStr("ab","abc"));
        System.out.println(longestCommonSubsequence.getLongestCommonStr("abcde","acd"));
    }
}
