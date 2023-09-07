package org.lee.leetcode.num1_20;

import java.util.HashMap;
import java.util.Map;

public class LC8_MyAtoi_Automaton {

    public static int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (automaton.get(s.charAt(i)))
                break;
        }
        return (int) (automaton.sign * automaton.ans);
    }

    public static class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private final Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[] {"start", "signed", "in_number", "end"});
            put("signed", new String[] {"end", "end", "in_number", "end"});
            put("in_number", new String[] {"end", "end", "in_number", "end"});
            put("end", new String[] {"end", "end", "end", "end"});
        }};

        public boolean get(char c) {
            state = table.get(state)[getCol(c)];
            switch (state) {
                case "start":
                    return false;
                case "signed":
                    if (c == '-')
                        sign = -1;
                    return false;
                case "in_number":
                    ans = c - '0' + ans * 10;
                    long n;
                    if (sign == 1 && ans > Integer.MAX_VALUE) {
                        ans = Integer.MAX_VALUE;
                        return true;
                    } else if (sign == -1 && ans > (n = -(long) Integer.MIN_VALUE)) {
                        ans = n;
                        return true;
                    }
                    return false;
                default:
                    return true;
            }
        }

        private int getCol(char c) {
            if (c == ' ')
                return 0;
            else if (c == '+' || c == '-')
                return 1;
            else if (Character.isDigit(c))
                return 2;
            else
                return 3;
        }
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
