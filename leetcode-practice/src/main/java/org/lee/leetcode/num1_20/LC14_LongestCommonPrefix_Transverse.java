package org.lee.leetcode.num1_20;

public class LC14_LongestCommonPrefix_Transverse {

    public static String longestCommonPrefix(String[] strs) {
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (len == 0)
                break;
            int j = 0;
            for (; j < len && j < strs[i].length(); j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j))
                    break;
            }
            len = j;
        }
        return strs[0].substring(0, len);
    }

    public static void testCase() {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("fl".equals(longestCommonPrefix(strs)));
    }

    public static void main(String[] args) {
        testCase();
    }

}
