package org.lee.leetcode.num201_220;

public class LC215_FindKthLargest_MaxHeap {

    public static int findKthLargest(int[] nums, int k) {
        int i, maxIndex = nums.length - 1;
        for (i = (nums.length >>> 1) - 1; i >= 0; i--)
            headAdjust(nums, i, maxIndex);
        for (i = maxIndex; i >= 0;) {
            swap(nums, 0, i);
            if (maxIndex - i + 1 == k)
                return nums[i];
            headAdjust(nums, 0, --i);
        }
        return -1;
    }

    private static void headAdjust(int[] nums, int begin, int end) {
        int dummy = nums[begin];
        for (int i = (begin << 1) + 1; i <= end; i = (i << 1) + 1) {
            if (i < end && nums[i] < nums[i + 1])
                i++;
            if (dummy > nums[i])
                break;
            nums[begin] = nums[i];
            begin = i;
        }
        nums[begin] = dummy;
    }

    private static void swap(int[] nums, int i, int j) {
        int d = nums[i];
        nums[i] = nums[j];
        nums[j] = d;
    }

    public static void testCase() {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2) == 5);
    }

    public static void main(String[] args) {
        testCase();
    }
}
