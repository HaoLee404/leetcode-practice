package org.lee.leetcode.num181_200;

public class LC198_Rob {

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int m = nums[0], n = Math.max(m, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int x = Math.max(n, m + nums[i]);
            m = n;
            n = x;
        }
        return n;
    }

}
