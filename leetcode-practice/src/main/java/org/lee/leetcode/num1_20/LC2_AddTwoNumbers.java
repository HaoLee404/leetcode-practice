package org.lee.leetcode.num1_20;

import org.lee.leetcode.common.ListNode;

public class LC2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode(), l = hair;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            l.next = new ListNode(sum % 10);
            l = l.next;
            add = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + add;
            l.next = new ListNode(sum % 10);
            l = l.next;
            add = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + add;
            l.next = new ListNode(sum % 10);
            l = l.next;
            add = sum / 10;
            l2 = l2.next;
        }
        if (add > 0)
            l.next = new ListNode(add);
        return hair.next;
    }

}
