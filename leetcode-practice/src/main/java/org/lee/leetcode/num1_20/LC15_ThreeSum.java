package org.lee.leetcode.num1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序是为了避免重复的问题
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(len / 3 + 1);
        FINISH: {
            for (int i = 0; i < len - 2; i++) {
                int x = nums[i];
                if (x > 0)
                    break;
                if (i > 0 && x == nums[i - 1])
                    continue;
                int ji = i + 1, ki = len - 1;
                for (int j = ji, k = ki; j < k; j++) {
                    int y = nums[j];
                    if (nums[i] + y > 0)
                        break FINISH;
                    if (j > ji && y == nums[j - 1])
                        continue;
                    for (; k > j; k--) {
                        int z = nums[k];
                        if (k < ki && z == nums[k + 1])
                            continue;
                        int sum = x + y + z;
                        if (sum == 0) {
                            List<Integer> list = new ArrayList<>(3);
                            list.add(x);
                            list.add(y);
                            list.add(z);
                            //res.add(Arrays.asList(x, y, z));
                            res.add(list);
                        } else if (sum < 0)
                            break;
                    }
                }
            }
        }
        return res;
    }

    public static void testCase() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public static void testCase1() {
        int[] nums = {0,1,1};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public static void testCase2() {
        int[] nums = {0,0,0};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
    }
}
