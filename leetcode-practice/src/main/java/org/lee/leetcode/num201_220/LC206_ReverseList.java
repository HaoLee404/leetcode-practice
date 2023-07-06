package org.lee.leetcode.num201_220;

import org.lee.leetcode.common.ListNode;

public class LC206_ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void testCase() {
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        ListNode.print(reverseList(head));
    }

    public static void testCase1() {
        int[] arr = {1};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        ListNode.print(reverseList(head));
    }

    public static void testCase2() {
        ListNode.print(reverseList(null));
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
    }
}
