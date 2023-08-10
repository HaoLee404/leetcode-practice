package org.lee.leetcode.num61_80;

public class LC70_ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int x = 1, y = 2;
        for (int i = 3; i <= n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }

        return y;
    }

}
