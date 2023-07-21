package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.ListNode;

public class LC142_DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head, meet = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        if (meet != null) {
            ListNode curr = head;
            while (true) {
                if (curr == meet)
                    return curr;
                curr = curr.next;
                meet = meet.next;
            }
        }
        return null;
    }

}
