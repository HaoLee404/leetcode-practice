package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.ListNode;

public class LC160_GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        while (currA != null || currB != null) {
            if (currA == currB)
                return currA;
            if (currA != null)
                currA = currA.next;
            else
                currA = headB;
            if (currB != null)
                currB = currB.next;
            else
                currB = headA;
        }
        return null;
    }

}
