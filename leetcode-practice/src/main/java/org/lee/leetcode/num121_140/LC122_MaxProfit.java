package org.lee.leetcode.num121_140;

public class LC122_MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1)
            return maxProfit;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += (prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }

}
