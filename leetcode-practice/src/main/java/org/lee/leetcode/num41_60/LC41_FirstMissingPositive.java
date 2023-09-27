package org.lee.leetcode.num41_60;

public class LC41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length, n = len + 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 1)
                nums[i] = n;
        }
        for (int i = 0; i < len; i++) {
            int m = Math.abs(nums[i]);
            int k = m - 1;
            if (m <= len && nums[k] > 0)
                nums[k] = -nums[k];
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n;
    }

}
