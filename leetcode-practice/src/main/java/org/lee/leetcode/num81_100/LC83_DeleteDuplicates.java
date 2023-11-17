package org.lee.leetcode.num81_100;

import org.lee.leetcode.common.ListNode;

public class LC83_DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            if (prev != null && prev.val == curr.val)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
        return head;
    }

}
