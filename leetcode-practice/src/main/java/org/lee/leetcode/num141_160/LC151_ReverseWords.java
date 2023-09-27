package org.lee.leetcode.num141_160;

public class LC151_ReverseWords {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int count = 0;
        char blank = ' ';
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == blank) {
                if (count != 0) {
                    int j = i + 1;
                    sb.append(s, j, j + count).append(blank);
                    count = 0;
                }
            } else
                ++count;
        }
        if (count != 0)
            sb.append(s, 0, count);
        else
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

}
