package org.lee.leetcode.num1_20;

public class LC8_MyAtoi {

    public static int myAtoi(String s) {
        char[] arr = s.toCharArray();
        int sign = 1;
        long res = 0L;
        boolean inNum = false;
        for (char c : arr) {
            if (inNum) {
                if (Character.isDigit(c)) {
                    res = c - '0' + res * 10;
                    if (res > Integer.MAX_VALUE) {
                        if (sign == 1)
                            return Integer.MAX_VALUE;
                        else
                            return Integer.MIN_VALUE;
                    }
                } else
                    break;
            } else {
                if (c == ' ')
                    continue;
                else if (c == '-') {
                    sign = -1;
                    inNum = true;
                } else if (c == '+')
                    inNum = true;
                else if (Character.isDigit(c)) {
                    res = c - '0' + res * 10;
                    inNum = true;
                } else
                    break;
            }
        }
        return (int) (sign * res);
    }

    public static void testCase() {
        System.out.println(myAtoi("42") == 42);
    }

    public static void testCase1() {
        System.out.println(myAtoi("   -42") == -42);
    }

    public static void testCase2() {
        System.out.println(myAtoi("4193 with words") == 4193);
    }

    public static void testCase3() {
        System.out.println(myAtoi("  +4193 w") == 4193);
    }

    public static void testCase4() {
        System.out.println(myAtoi("000") == 0);
    }

    public static void testCase5() {
        System.out.println(myAtoi("we") == 0);
    }

    public static void testCase6() {
        System.out.println(myAtoi("+-12") == 0);
    }

    public static void testCase7() {
        System.out.println(myAtoi("  +  413") == 0);
    }

    public static void testCase8() {
        System.out.println(myAtoi("  +9999999999999") == Integer.MAX_VALUE);
    }

    public static void testCase9() {
        System.out.println(myAtoi("  -9999999999999") == Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
        testCase7();
        testCase8();
        testCase9();
    }

}
