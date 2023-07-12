package org.lee.leetcode.num1_20;

import java.util.Deque;
import java.util.LinkedList;

public class LC20_IsValid {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != '{')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
