package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.ListNode;

public class LC141_HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

}
