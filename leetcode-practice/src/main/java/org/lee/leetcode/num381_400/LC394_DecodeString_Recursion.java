package org.lee.leetcode.num381_400;

public class LC394_DecodeString_Recursion {

    private int index;

    private String s;

    public String decodeString(String s) {
        index = 0;
        this.s = s;
        return decode();
    }

    private String decode() {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (Character.isDigit(c))
                num = c - '0' + num * 10;
            else if (c == '[') {
                String str = decode();
                for (int j = 0; j < num; j++)
                    sb.append(str);
                num = 0;
            } else if (c == ']')
                break;
            else
                sb.append(c);
        }
        return sb.toString();
    }

}
