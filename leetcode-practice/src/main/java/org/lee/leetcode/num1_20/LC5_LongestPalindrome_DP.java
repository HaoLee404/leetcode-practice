package org.lee.leetcode.num1_20;

public class LC5_LongestPalindrome_DP {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        int beginning = 0, maxLen = 1;
        char[] charArr = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArr[i] != charArr[j])
                    dp[i][j] = false;
                else {
                    int subStrLen = j - i + 1;
                    if (subStrLen <= 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] && subStrLen > maxLen) {
                        maxLen = subStrLen;
                        beginning = i;
                    }
                }
            }
        }
        return s.substring(beginning, beginning + maxLen);
    }

}
