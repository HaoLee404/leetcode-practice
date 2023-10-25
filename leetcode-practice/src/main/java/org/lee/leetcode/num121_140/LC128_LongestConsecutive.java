package org.lee.leetcode.num121_140;

import java.util.HashSet;

public class LC128_LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) set.add(num);
        int maxLen = 0;
        for (int i = 0; i < nums.length && !set.isEmpty(); i++) {
            int len1 = 0;
            for (int j = nums[i];; j++) {
                if (set.remove(j))
                    len1++;
                else
                    break;
            }
            int len2 = 0;
            for (int j = nums[i] - 1;; j--) {
                if (set.remove(j))
                    len2++;
                else
                    break;
            }
            maxLen = Math.max(maxLen, len1 + len2);
        }
        return maxLen;
    }

}
