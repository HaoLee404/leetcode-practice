package org.lee.leetcode.num1_20;

public class LC5_LongestPalindrome_ExpandAroundCenter {

    // aba
    //  1 - (3 - 1) / 2
    // abba
    //  12
    //  1 - (4 - 1) / 2
    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int beginning = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));
            if (len > maxLen) {
                maxLen = len;
                beginning = i - (len - 1 >>> 1);
            }
        }
        return s.substring(beginning, beginning + maxLen);
    }

    private static int expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // r - l + 1 - 2
        return r - l - 1;
    }

    public static void testCase() {
        String s = "babad";
        String ans1 = "bab";
        String ans2 = "aba";
        String res = longestPalindrome(s);
        System.out.println(ans1.equals(res) || ans2.equals(res));
    }

    public static void testCase1() {
        String s = "cbbd";
        String ans1 = "bb";
        String res = longestPalindrome(s);
        System.out.println(ans1.equals(res));
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
    }
}
