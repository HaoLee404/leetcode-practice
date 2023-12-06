package org.lee.leetcode.num21_40;

import org.lee.leetcode.common.ListNode;

public class LC24_SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode prevPrev = null, prev = hair, curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            ListNode next = curr.next;
            if (count == 2) {
                count = 0;
                prevPrev.next = curr;
                curr.next = prev;
                prev.next = next;
            } else {
                prevPrev = prev;
                prev = curr;
            }
            curr = next;
        }
        return hair.next;
    }

}
