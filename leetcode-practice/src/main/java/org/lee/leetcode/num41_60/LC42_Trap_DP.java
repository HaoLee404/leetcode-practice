package org.lee.leetcode.num41_60;

public class LC42_Trap_DP {

    public int trap(int[] height) {
        int[] maxLeftHeight = new int[height.length];
        maxLeftHeight[0] = height[0];
        for (int i = 1; i < height.length; i++)
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i]);

        int[] maxRightHeight = new int[height.length];
        int maxIndex = height.length - 1;
        maxRightHeight[maxIndex] = height[maxIndex];
        for (int i = maxIndex - 1; i >= 0; i--)
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i]);

        int res = 0;
        for (int i = 0; i < height.length; i++)
            res += Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];

        return res;
    }

}
