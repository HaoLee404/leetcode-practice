package org.lee.leetcode.num161_180;

import java.util.Arrays;
import java.util.Comparator;

public class LC179_LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strArr[i] = nums[i] + "";
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o1.length() + o2.length();
                for (int i = 0; i < len; i++) {
                    char c1, c2;
                    if (i < o1.length())
                        c1 = o1.charAt(i);
                    else
                        c1 = o2.charAt(i - o1.length());
                    if (i < o2.length())
                        c2 = o2.charAt(i);
                    else
                        c2 = o1.charAt(i - o2.length());
                    if (c1 > c2)
                        return -1;
                    else if (c1 < c2)
                        return 1;
                }
                return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s : strArr) res.append(s);
        if (res.charAt(0) == '0')
            return "0";
        return res.toString();
    }

}
