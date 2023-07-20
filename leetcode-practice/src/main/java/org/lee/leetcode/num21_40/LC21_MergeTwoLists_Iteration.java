package org.lee.leetcode.num21_40;

import org.lee.leetcode.common.ListNode;

public class LC21_MergeTwoLists_Iteration {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode hair = new ListNode(), curr1 = list1, curr2 = list2, list = hair;
        while (curr1 != null && curr2 != null) {
            if (curr1.val > curr2.val) {
                list.next = curr2;
                curr2 = curr2.next;
            } else {
                list.next = curr1;
                curr1 = curr1.next;
            }
            list = list.next;
        }
        if (curr1 != null)
            list.next = curr1;
        if (curr2 != null)
            list.next = curr2;

        return hair.next;
    }

}
