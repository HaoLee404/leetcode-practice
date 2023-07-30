package org.lee.leetcode.num61_80;

public class LC72_MinDistance {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0)
            return len2;
        if (len2 == 0)
            return len1;
        int m = len1 + 1, n = len2 + 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = i;
        for (int j = 0; j < n; j++)
            dp[0][j] = j;
        for (int i = 1; i < m; i++) {
            int il = i - 1;
            char c1 = word1.charAt(il);
            for (int j = 1; j < n; j++) {
                int jd = j - 1, min = Math.min(dp[il][j], dp[i][jd]) + 1;
                if (c1 == word2.charAt(jd))
                    dp[i][j] = Math.min(min, dp[il][jd]);
                else
                    dp[i][j] = Math.min(min, dp[il][jd] + 1);
            }
        }
        return dp[len1][len2];
    }

}
