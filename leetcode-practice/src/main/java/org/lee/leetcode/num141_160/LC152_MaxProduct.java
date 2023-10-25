package org.lee.leetcode.num141_160;

public class LC152_MaxProduct {

    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE, product = 1;
        for (int num : nums) {
            product *= num;
            maxProduct = Math.max(maxProduct, product);
            if (product == 0)
                product = 1;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0)
                product = 1;
        }
        return maxProduct;
    }

}
