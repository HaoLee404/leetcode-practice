package org.lee.leetcode.num381_400;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC394_DecodeString_Stack {

    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder().append(c);
                while (++i < s.length() && Character.isDigit(c = s.charAt(i)))
                    num.append(c);
                stack.push(num.toString());
                i--;
            } else if (c == ']') {
                List<String> list = new ArrayList<>();
                String str;
                while (!"[".equals(str = stack.pop()))
                    list.add(str);
                int num = Integer.parseInt(stack.pop());
                for (int j = 0; j < num; j++) {
                    for (int k = list.size() - 1; k >= 0; k--)
                        stack.push(list.get(k));
                }
            } else
                stack.push(c + "");
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }

}
