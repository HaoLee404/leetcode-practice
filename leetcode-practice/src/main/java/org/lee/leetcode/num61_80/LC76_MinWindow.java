package org.lee.leetcode.num61_80;

import java.util.HashMap;
import java.util.Map;

public class LC76_MinWindow {

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        // t中还未在窗口中出现的字符计数
        Map<Character, Integer> notInWindow = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            Integer count = notInWindow.get(c);
            notInWindow.put(c, count == null ? 1 : count + 1);
        }
        // t中已经在窗口中出现的字符计数
        Map<Character, Integer> inWindow = new HashMap<>();
        // t中在窗口中出现但超出t中出现次数的字符计数
        Map<Character, Integer> inWindowButGT = new HashMap<>();
        int start = 0, minLen = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            Character c = s.charAt(r);
            Integer count = notInWindow.get(c);
            if (count != null) {
                if (count == 1)
                    inWindow.put(c, notInWindow.remove(c));
                else {
                    notInWindow.put(c, count - 1);
                    inWindow.put(c, 1);
                }
            } else {
                if (inWindow.containsKey(c)) {
                    count = inWindowButGT.get(c);
                    inWindowButGT.put(c, count == null ? 1 : count + 1);
                }
            }
            if (notInWindow.isEmpty()) {
                int len = r - l + 1;
                if (minLen == 0) {
                    minLen = len;
                    start = l;
                } else {
                    if (len < minLen) {
                        minLen = len;
                        start = l;
                    }
                }
                while (l <= r) {
                    c = s.charAt(l++); // 移动窗口左边界
                    count = inWindowButGT.get(c);
                    if (count != null) {
                        if (count == 1)
                            inWindowButGT.remove(c);
                        else
                            inWindowButGT.put(c, count - 1);
                        len = r - l + 1;
                        if (len < minLen) {
                            minLen = len;
                            start = l;
                        }
                    } else {
                        count = inWindow.get(c);
                        if (count != null) {
                            if (count == 1)
                                notInWindow.put(c, inWindow.remove(c));
                            else {
                                notInWindow.put(c, 1);
                                inWindow.put(c, count - 1);
                            }
                            break; // 此时s没有覆盖t
                        } else { // s覆盖了t，且字符c没有出现在t中
                            len = r - l + 1;
                            if (len < minLen) {
                                minLen = len;
                                start = l;
                            }
                        }
                    }
                }
            }
        }
        return s.substring(start, start + minLen);
    }

}
