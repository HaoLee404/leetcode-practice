package org.lee.leetcode.num701_720;

public class LC704_BinarySearch {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + hi >>> 1, midV = nums[mid];
            if (midV == target)
                return mid;
            else if (midV > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }

}
