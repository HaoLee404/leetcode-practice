package org.lee.leetcode.num1_20;

import java.util.HashMap;

public class LC3_LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            Character c = s.charAt(r);
            Integer index = map.get(c);
            if (index != null)
                l = Math.max(l, index + 1);
            maxLen = Math.max(maxLen, r - l + 1);
            map.put(c, r);
        }
        return maxLen;
    }

    public static void testCase() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s) == 3);
    }

    public static void testCase1() {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s) == 1);
    }

    public static void testCase2() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s) == 3);
    }

    public static void testCase3() {
        String s = "";
        System.out.println(lengthOfLongestSubstring(s) == 0);
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
        testCase3();
    }
}
