package org.lee.leetcode.num161_180;

public class LC169_MajorityElement {

    // 摩尔投票
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else {
                if (nums[i] == res)
                    count++;
                else
                    count--;
            }
        }
        return res;
    }

}
