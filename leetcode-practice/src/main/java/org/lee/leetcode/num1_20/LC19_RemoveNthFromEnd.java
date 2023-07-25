package org.lee.leetcode.num1_20;

import org.lee.leetcode.common.ListNode;

public class LC19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode(), lp = null, l = null, r = head;
        hair.next = head;
        int count = 1;
        while (true) {
            if (count++ == n) {
                lp = hair;
                l = head;
            }
            if (r.next == null)
                break;
            r = r.next;
            if (l != null) {
                lp = l;
                l = l.next;
            }
        }
        lp.next = l.next;

        return hair.next;
    }

}
