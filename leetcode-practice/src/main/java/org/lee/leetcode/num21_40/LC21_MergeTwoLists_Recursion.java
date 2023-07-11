package org.lee.leetcode.num21_40;

import org.lee.leetcode.common.ListNode;

public class LC21_MergeTwoLists_Recursion {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val > l2.val) {
            l2.next = merge(l1, l2.next);
            return l2;
        } else {
            l1.next = merge(l1.next, l2);
            return l1;
        }
    }
}
