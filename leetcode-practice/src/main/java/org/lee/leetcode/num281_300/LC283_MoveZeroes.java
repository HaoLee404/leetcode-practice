package org.lee.leetcode.num281_300;

public class LC283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0)
                nums[l++] = nums[r];
        }
        while (l < nums.length)
            nums[l++] = 0;
    }

}
