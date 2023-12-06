package org.lee.leetcode.num201_220;

public class LC209_MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, minLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                while (l <= r) {
                    sum -= nums[l++];
                    if (sum < target)
                        break;
                    minLen = Math.min(minLen, r - l + 1);
                }
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

}
