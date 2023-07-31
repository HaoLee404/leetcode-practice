package org.lee.leetcode.num1141_1160;

public class LC1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int il = i - 1;
            char c1 = text1.charAt(il);
            for (int j = 1; j <= n; j++) {
                int jd = j - 1;
                if (c1 == text2.charAt(jd))
                    dp[i][j] = dp[il][jd] + 1;
                else
                    dp[i][j] = Math.max(dp[il][j], dp[i][jd]);
            }
        }
        return dp[m][n];
    }

}
