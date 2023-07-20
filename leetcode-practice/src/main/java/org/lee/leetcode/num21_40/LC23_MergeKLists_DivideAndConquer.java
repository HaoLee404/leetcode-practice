package org.lee.leetcode.num21_40;

import org.lee.leetcode.common.ListNode;

public class LC23_MergeKLists_DivideAndConquer {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        if (left > right)
            return null;
        int mid = left + right >>> 1;
        return merge2Lists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head, curr, curr1, curr2;
        if (l1.val < l2.val) {
            head = l1;
            curr1 = l1.next;
            curr2 = l2;
        } else {
            head = l2;
            curr1 = l1;
            curr2 = l2.next;
        }
        curr = head;
        while (curr1 != null || curr2 != null) {
            if (curr1 != null && curr2 != null) {
                if (curr1.val < curr2.val) {
                    curr.next = curr1;
                    curr1 = curr1.next;
                } else {
                    curr.next = curr2;
                    curr2 = curr2.next;
                }
            } else if (curr1 == null) {
                curr.next = curr2;
                curr2 = curr2.next;
            } else {
                curr.next = curr1;
                curr1 = curr1.next;
            }
            curr = curr.next;
        }
        return head;
    }

}
