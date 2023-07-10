package org.lee.leetcode.num41_60;

public class LC53_MaxSubArray {

    /*public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int l = 0, r = 0, sum = 0; r < nums.length; r++) {
            sum += nums[r];
            max = Math.max(max, sum);
            if (sum <= 0) {
                while (l <= r && sum <= 0) {
                    sum -= nums[l++];
                    if (l > r)
                        break;
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }*/

    /**
     * 动态规划解法。f(i)表示以索引i结尾的子数组的和的最大值。
     * f(i) = max{f(i − 1) + nums[i], nums[i]}
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], dp = 0;
        for (int i : nums) {
            dp = Math.max(dp + i, i);
            max = Math.max(max, dp);
        }
        return max;
    }

}
