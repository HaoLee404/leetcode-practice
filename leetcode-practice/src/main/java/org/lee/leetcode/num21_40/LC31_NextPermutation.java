package org.lee.leetcode.num21_40;

public class LC31_NextPermutation {

    // 4,5,2,6,3,1
    public static void nextPermutation(int[] nums) {
        int len = nums.length, index = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        int reverseBegin = 0;
        if (index >= 0) {
            for (int i = len - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, index, i);
                    break;
                }
            }
            reverseBegin = index + 1;
        }
        reverse(nums, reverseBegin);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int begin) {
        int left = begin, right = nums.length - 1;
        while (left < right)
            swap(nums, left++, right--);
    }

    public static void testCase() {
        int[] nums = {4,5,2,6,3,1};
        nextPermutation(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        testCase();
    }

}
