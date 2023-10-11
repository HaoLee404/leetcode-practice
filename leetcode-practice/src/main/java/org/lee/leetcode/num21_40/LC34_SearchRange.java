package org.lee.leetcode.num21_40;

public class LC34_SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int[] res = new int[] {-1, -1};
        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            if (nums[mid] == target) {
                if (mid - 1 < 0 || nums[mid - 1] != target) {
                    res[0] = mid;
                    hi = nums.length - 1; // 有关联
                }
                if (mid + 1 >= nums.length || nums[mid + 1] != target)
                    res[1] = mid;
                if (res[0] != -1 && res[1] != -1)
                    break;
                else if (res[0] != -1)
                    lo = mid + 1;
                else
                    hi = mid - 1; // 有关联
            } else if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return res;
    }

}
