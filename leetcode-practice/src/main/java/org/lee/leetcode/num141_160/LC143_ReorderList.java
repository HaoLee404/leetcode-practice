package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.ListNode;

public class LC143_ReorderList {

    /**
     *
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 -> 2 -> 3 -> 4
     *
     * 1 -> 2
     * 5 -> 4 -> 3
     * 1 -> 5 -> 2 -> 4 -> null
     */
    public static void reorderList(ListNode head) {
        ListNode mid = split(head);
        ListNode rightHead = reverse(mid);
        merge(head, rightHead);
    }

    private static ListNode split(ListNode head) {
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null)
            prev.next = null;
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void merge(ListNode leftHead, ListNode rightHead) {
        if (leftHead == rightHead)
            return;
        ListNode left = leftHead, right = rightHead;
        while (right != null) {
            ListNode nextL = left.next;
            ListNode nextR = right.next;
            left.next = right;
            if (nextL == null)
                break;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    public static void testCase() {
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        reorderList(head);
        ListNode.print(head);
        System.out.println("------------");
    }

    public static void testCase1() {
        int[] arr = {1,2,3,4};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        reorderList(head);
        ListNode.print(head);
        System.out.println("------------");
    }

    public static void testCase2() {
        int[] arr = {1};
        ListNode head = ListNode.init(arr);
        ListNode.print(head);
        reorderList(head);
        ListNode.print(head);
        System.out.println("------------");
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
    }

}
