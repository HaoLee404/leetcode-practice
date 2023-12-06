package org.lee.leetcode.num541_560;

import java.util.HashMap;

public class LC560_SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer count = map.get(sum - k);
            if (count != null)
                ans += count;
            count = map.get(sum);
            if (count == null)
                map.put(sum, 1);
            else
                map.put(sum, count + 1);
        }
        return ans;
    }

}
