package org.lee.leetcode.num21_40;

public class LC33_Search {

    public static int search(int[] nums, int target) {
        int maxIndex = nums.length - 1;
        if (nums[0] > nums[maxIndex]) {
            if (target >= nums[0])
                return binarySearchLeft(nums, target, maxIndex);
            else if (target <= nums[maxIndex])
                return binarySearchRight(nums, target, maxIndex);
            else
                return -1;
        } else
            return binarySearch(nums, target, maxIndex);
    }

    private static int binarySearchRight(int[] nums, int target, int maxIndex) {
        int lo = 0, hi = maxIndex;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            if (target == nums[mid])
                return mid;
            else if (nums[mid] < nums[maxIndex] && nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }

    private static int binarySearchLeft(int[] nums, int target, int maxIndex) {
        int lo = 0, hi = maxIndex;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            if (target == nums[mid])
                return mid;
            else if (nums[mid] >= nums[0] && nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int target, int maxIndex) {
        int lo = 0, hi = maxIndex;
        while (lo <= hi){
            int mid = lo + hi >>> 1;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }

    public static void testCase() {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0) == 4);
    }

    public static void testCase1() {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 3) == -1);
    }

    public static void testCase2() {
        int[] nums = {1};
        System.out.println(search(nums, 0) == -1);
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
    }

}
