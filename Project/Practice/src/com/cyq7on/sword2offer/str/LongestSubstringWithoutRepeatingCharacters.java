package com.cyq7on.sword2offer.str;


import java.util.HashMap;
import java.util.Map;

/**
 * @author cyq7on
 * @description 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/3/10
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        //剑指offer中指定了字符只包含a-z可以用数组，LeetCode上没有，故改用map
//        int[] status = new int[26];
        Map<Character, Integer> status = new HashMap<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (status.containsKey(ch)) {
//                left = Math.max(left, status.get(ch) + 1);
                int val = status.get(ch) + 1;
                if (left < val) {
                    left = val;
                }
            }
            status.put(ch, i);
//            length = Math.max(length, i - left + 1);
            int val = i - left + 1;
            if (length < val) {
                length = val;
            }
        }
        return length;
    }

    public int lengthOfLongestSubstring0(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int[] status = new int[26];
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (status[index] == 0) {
                right++;
                status[index] = i + 1;
            } else {
                length = Math.max(length, right - left);
                left = status[index] - 1;
                //这也有问题
                for (int j = 0; j <= left; j++) {
                    status[j] = 0;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(characters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(characters.lengthOfLongestSubstring("bbbbb"));
        System.out.println(characters.lengthOfLongestSubstring("pwwkew"));
        System.out.println(characters.lengthOfLongestSubstring("aaaa"));
    }
}
