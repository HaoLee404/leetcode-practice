package org.lee.leetcode.num161_180;

public class LC165_CompareVersion {

    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        for (int i = 0, j = 0; i < len1 || j < len2; ) {
            int x = 0;
            while (i < len1) {
                char c = version1.charAt(i++);
                if (x == 0 && c == '0')
                    continue;
                else if (c == '.')
                    break;
                else
                    x = c - '0' + x * 10;
            }
            int y = 0;
            while (j < len2) {
                char c = version2.charAt(j++);
                if (y == 0 && c == '0')
                    continue;
                else if (c == '.')
                    break;
                else
                    y = c - '0' + y * 10;
            }
            if (x > y)
                return 1;
            else if (x < y)
                return -1;
        }
        return 0;
    }

}
