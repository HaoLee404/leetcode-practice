package org.lee.leetcode.num701_720;

public class LC718_FindLength_SlideWindow {

    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int k = i, j = 0, len = 0; k < nums1.length && j < nums2.length; ) {
                if (nums1[k++] == nums2[j++])
                    maxLen = Math.max(++len, maxLen);
                else
                    len = 0;
            }
        }
        for (int j = 1; j < nums2.length; j++) {
            for (int k = j, i = 0, len = 0; k < nums2.length && i < nums1.length; ) {
                if (nums2[k++] == nums1[i++])
                    maxLen = Math.max(++len, maxLen);
                else
                    len = 0;
            }
        }
        return maxLen;
    }

}
