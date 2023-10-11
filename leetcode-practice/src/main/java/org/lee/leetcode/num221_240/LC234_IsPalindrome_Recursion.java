package org.lee.leetcode.num221_240;

import org.lee.leetcode.common.ListNode;

public class LC234_IsPalindrome_Recursion {

    private ListNode frontPointer;

    // 1 2 2 1
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currNode) {
        if (currNode != null) {
            if (!recursivelyCheck(currNode.next))
                return false;
            if (currNode.val != frontPointer.val)
                return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

}
