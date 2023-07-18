package org.lee.leetcode.num81_100;

import org.lee.leetcode.common.ListNode;

public class LC92_ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode(), prev = hair, curr = head, leftPrev = null;
        hair.next = head;
        int count = 0;
        while (curr != null) {
            if (++count < left) {
                prev = curr;
                curr = curr.next;
            } else if (count == left) {
                if (count == right)
                    break;
                leftPrev = prev;
                prev = curr;
                curr = curr.next;
            } else {
                ListNode currNext = curr.next, leftPrevNext = leftPrev.next;
                leftPrev.next = curr;
                curr.next = leftPrevNext;
                prev.next = currNext;
                if (count == right)
                    break;
                else
                    curr = currNext;
            }
        }
        return hair.next;
    }

    public static void testCase() {
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        head = reverseBetween(head, 2, 4);
        ListNode.print(head);
    }

    public static void testCase1() {
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        head = reverseBetween(head, 2, 2);
        ListNode.print(head);
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
    }

}
