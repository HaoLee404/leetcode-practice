package org.lee.leetcode.num81_100;

import java.util.LinkedList;
import java.util.List;

public class LC93_RestoreIpAddresses {

    static final int SEG_COUNT = 4;

    List<String> ans = null;

    int[] segments = null;

    public List<String> restoreIpAddresses(String s) {
        ans = new LinkedList<>();
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segId, int start) {
        int len = s.length();
        if (segId == SEG_COUNT) { // 只有四段, 所以退出
            if (start == len) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++)
                    ipAddr.append(segments[i]).append('.');
                ipAddr.deleteCharAt(ipAddr.length() - 1);
                ans.add(ipAddr.toString());
            }
            return;
        }
        if (start == len) // 字符串遍历完退出
            return;
        if (s.charAt(start) == '0') { // 以0开头的只能是0, 其他不合法
            segments[segId] = 0;
            dfs(s, segId + 1, start + 1);
            return;
        }
        int addr = 0;
        for (int end = start; end < len; end++) {
            addr = addr * 10 + (s.charAt(end) - '0');
            if (addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, end + 1);
            } else
                break;
        }
    }

}
