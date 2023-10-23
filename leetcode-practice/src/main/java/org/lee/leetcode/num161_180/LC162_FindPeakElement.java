package org.lee.leetcode.num161_180;

public class LC162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + hi >>> 1, midL = mid - 1, midR = mid + 1;
            if (midL >= 0) {
                if (midR < nums.length) {
                    if (nums[mid] > nums[midL] && nums[mid] > nums[midR])
                        return mid;
                    else if (nums[mid] > nums[midL] && nums[mid] < nums[midR])
                        lo = midR;
                    else if (nums[mid] < nums[midL] && nums[mid] > nums[midR])
                        hi = midL;
                    else {
                        if (nums[midL] < nums[midR])
                            lo = midR;
                        else
                            hi = midL;
                    }
                } else {
                    if (nums[midL] < nums[mid])
                        return mid;
                    hi = midL;
                }
            } else {
                if (midR < nums.length) {
                    if (nums[midR] < nums[mid])
                        return mid;
                    lo = midR;
                } else
                    return mid;
            }
        }
        return -1;
    }

}
