package org.lee.leetcode.num61_80;

public class LC69_MySqrt {

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + r >>> 1;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

}
