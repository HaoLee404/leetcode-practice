package org.lee.leetcode.num21_40;

import org.lee.leetcode.common.ListNode;

public class LC25_ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode prev = hair;
        while (head != null) {
            ListNode curr = prev;
            for (int i = 0; i < k; i++) {
                curr = curr.next;
                if (curr == null)
                    return hair.next;
            }
            ListNode next = curr.next;
            reverse(head, curr);
            prev.next = curr;
            head.next = next;
            prev = head;
            head = head.next;
        }
        return hair.next;
    }

    private static void reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public static void testCase() {
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        head = reverseKGroup(head, 3);
        ListNode.print(head);
    }

    public static void testCase1() {
        int[] arr = {1,2,3,4};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        head = reverseKGroup(head, 2);
        ListNode.print(head);
    }

    public static void testCase2() {
        int[] arr = {1};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        head = reverseKGroup(head, 1);
        ListNode.print(head);
    }

    public static void testCase3() {
        int[] arr = {1};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        head = reverseKGroup(head, 2);
        ListNode.print(head);
    }


    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
        testCase3();
    }

}
