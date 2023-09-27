package org.lee.leetcode.num321_340;

import java.util.Arrays;

public class LC322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        int len = amount + 1;
        int[] dp = new int[len];
        Arrays.fill(dp, len);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] < len ? dp[amount] : -1;
    }

}
