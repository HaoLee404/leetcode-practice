package org.lee.leetcode.num21_40;

public class LC32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int lc = 0, rc = 0, len = s.length(), maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                ++lc;
            else
                ++rc;

            if (lc == rc)
                maxLen = Math.max(maxLen, rc << 1);
            else if (rc > lc) {
                lc = 0;
                rc = 0;
            }
        }
        lc = 0;
        rc = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                ++rc;
            else
                ++lc;

            if (rc == lc)
                maxLen = Math.max(maxLen, rc << 1);
            else if (lc > rc) {
                lc = 0;
                rc = 0;
            }
        }

        return maxLen;
    }

}
