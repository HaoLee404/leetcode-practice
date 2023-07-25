package org.lee.leetcode.num41_60;

public class LC42_Trap_DoublePointer {

    /**
     * 假设 i < j, 现在有iLeftMax、iRightMax、jLeftMax、jRightMax。
     * 由动态规划的解法可知: iLeftMax <= jLeftMax; iRightMax >= jRightMax.
     * 当iLeftMax <= jRightMax时，必然有iLeftMax <= iRightMax，此时iLeftMax - height[i]就是i出的接水量。
     * j同理。
     */
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, lm = height[l], rm = height[r], res = 0;
        while (l <= r) {
            if (lm <= rm) {
                res += lm - height[l++];
                if (l < height.length)
                    lm = Math.max(lm, height[l]);
            } else {
                res += rm - height[r--];
                if (r >= 0)
                    rm = Math.max(rm, height[r]);
            }
        }
        return res;
    }

}
