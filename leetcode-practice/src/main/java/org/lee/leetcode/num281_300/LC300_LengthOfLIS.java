package org.lee.leetcode.num281_300;

public class LC300_LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        int len = 1;
        d[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxIndex = len - 1;
            if (nums[i] > d[maxIndex])
                d[len++] = nums[i];
            else {
                int lo = 0, hi = maxIndex;
                while (lo <= hi) {
                    int mid = lo + hi >>> 1;
                    if (nums[i] < d[mid]) {
                        int midL = mid - 1;
                        if (midL >= 0) {
                            if (nums[i] > d[midL]) {
                                d[mid] = nums[i];
                                break;
                            } else if (nums[i] == d[midL])
                                break;
                            else
                                hi = midL;
                        } else {
                            d[mid] = nums[i];
                            break;
                        }
                    } else if (nums[i] > d[mid]) {
                        int midR = mid + 1;
                        if (midR < len) {
                            if (nums[i] <= d[midR]) {
                                d[midR] = nums[i];
                                break;
                            } else
                                lo = midR;
                        } else
                            break;
                    } else
                        break;
                }
            }
        }
        return len;
    }

}
