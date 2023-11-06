package org.lee.leetcode.num221_240;

import java.util.Deque;
import java.util.LinkedList;

public class LC227_Calculate {

    // 1 + 2 * 3 / 2 - 1 = 3
    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char op = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = c - '0' + num * 10;
            else if (c == ' ')
                continue;
            else {
                operate(op, stack, num);
                num = 0;
                op = c;
            }
        }
        operate(op, stack, num);
        num = 0;
        while (!stack.isEmpty())
            num += stack.pop();
        return num;
    }

    private static void operate(char op, Deque<Integer> stack, int num) {
        switch (op) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
        }
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
    }

    public static void testCase() {
        String s = "11 + 2 * 33 / 2 - 1";
        System.out.println(calculate(s) == 43);
    }

    public static void testCase1() {
        String s = "1";
        System.out.println(calculate(s) == 1);
    }

}
