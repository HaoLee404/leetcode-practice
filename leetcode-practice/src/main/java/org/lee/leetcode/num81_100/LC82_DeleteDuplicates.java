package org.lee.leetcode.num81_100;

import org.lee.leetcode.common.ListNode;

public class LC82_DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode prev = hair, curr = head;
        boolean duplicate = false;
        while (curr != null) {
            ListNode next = curr.next;
            if (next != null && curr.val == next.val) {
                prev.next = next;
                duplicate = true;
            } else if (duplicate) {
                prev.next = next;
                duplicate = false;
            } else
                prev = curr;
            curr = next;
        }
        return hair.next;
    }

}
