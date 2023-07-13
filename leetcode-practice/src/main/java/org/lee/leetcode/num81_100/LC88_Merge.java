package org.lee.leetcode.num81_100;

public class LC88_Merge {

    /**
     *      m        n
     * |----------|----|
     * m - p1 - 1
     * n - p2 - 1
     * m + n - p1 - 1 > m + n - p1 - p2 - 2
     *  p2 > -1
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; ) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j])
                    nums1[k--] = nums1[i--];
                else
                    nums1[k--] = nums2[j--];
            } else if (j < 0)
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }

}
