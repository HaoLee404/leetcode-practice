package org.lee.leetcode.num1_20;

import java.util.HashMap;

public class LC1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            Integer value = map.get(key);
            if (value != null)
                return new int[] {value, i};
            map.put(nums[i], i);
        }
        return null;
    }
}
