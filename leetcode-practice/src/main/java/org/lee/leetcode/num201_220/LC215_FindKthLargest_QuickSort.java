package org.lee.leetcode.num201_220;

import java.util.Random;

public class LC215_FindKthLargest_QuickSort {

    private static final Random random  = new Random();

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k - 1, 0, nums.length - 1);
    }

    private static int findKthLargest(int[] nums, int index, int lo, int hi) {
        if (lo < hi) {
            int pivotIndex = partition(nums, lo, hi);
            if (pivotIndex == index)
                return nums[pivotIndex];
            else if (pivotIndex < index)
                return findKthLargest(nums, index, pivotIndex + 1, hi);
            else
                return findKthLargest(nums, index, lo, pivotIndex - 1);
        }
        return nums[lo];
    }

    private static int partition(int[] nums, int lo, int hi) {
        // 随机选择枢轴
        int r = lo + random.nextInt(hi - lo);
        swap(nums, lo, r);
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] <= pivot)
                hi--;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] >= pivot)
                lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
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
