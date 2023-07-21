package org.lee.leetcode.num281_300;

public class LC300_LengthOfLIS_DP {

    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以第i个元素结尾的子序列的最大长度
        int[] dp = new int[nums.length];
        int maxLen = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}
