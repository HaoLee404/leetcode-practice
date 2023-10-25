package org.lee.leetcode.num1_20;

public class LC14_LongestCommonPrefix_Direction {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        if (strs[0].length() == 0)
            return "";
        int len = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            boolean eq = true;
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    eq = false;
                    break;
                }
            }
            if (eq)
                len = i + 1;
            else
                break;
        }
        return strs[0].substring(0, len);
    }

}
