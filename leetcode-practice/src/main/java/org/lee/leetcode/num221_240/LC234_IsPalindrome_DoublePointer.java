package org.lee.leetcode.num221_240;

import org.lee.leetcode.common.ListNode;

public class LC234_IsPalindrome_DoublePointer {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null)
            slow = slow.next;
        while (prev != null || slow != null) {
            if (prev == null || slow == null)
                return false;
            if (prev.val != slow.val)
                return false;
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

}
