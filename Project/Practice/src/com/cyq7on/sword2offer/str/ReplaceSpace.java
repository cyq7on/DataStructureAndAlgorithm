package com.cyq7on.sword2offer.str;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        //优化：确定最终长度
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                len++;
            }
        }
        len = s.length() + 2 * len;

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' '){
                sb.append(c);
            }else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
