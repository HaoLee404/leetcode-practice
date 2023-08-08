package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.ListNode;

public class LC148_SortList_BottomToTop {

    public static ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        int len = length(head);
        ListNode hair = new ListNode();
        hair.next = head;
        for (int size = 1; size < len; size <<= 1) {
            ListNode prev = hair, curr = hair.next;
            while (curr != null) {
                ListNode list1 = curr;
                for (int i = 1; i < size && curr.next != null; i++)
                    curr = curr.next;
                ListNode list2 = curr.next;
                curr.next = null;
                curr = list2;
                for (int i = 1; i < size && curr != null && curr.next != null; i++)
                    curr = curr.next;
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                prev.next = merge2Lists(list1, list2);
                while (prev.next != null)
                    prev = prev.next;
                curr = next;
            }
        }
        return hair.next;
    }

    private static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private static ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode list;
        if (list1.val < list2.val) {
            list = list1;
            list1 = list1.next;
        } else {
            list = list2;
            list2 = list2.next;
        }
        ListNode head = list;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list.next = list1;
                list1 = list1.next;
            } else {
                list.next = list2;
                list2 = list2.next;
            }
            list = list.next;
        }
        if (list1 == null)
            list.next = list2;
        else
            list.next = list1;

        return head;
    }

    public static void testCase() {
        int[] nums = {2,1,4,3,5};
        ListNode head = ListNode.init(nums);
        head = sortList(head);
        ListNode.print(head);
    }

    public static void testCase1() {
        int[] nums = {1};
        ListNode head = ListNode.init(nums);
        head = sortList(head);
        ListNode.print(head);
    }

    public static void testCase2() {
        int[] nums = {1,4,3,2};
        ListNode head = ListNode.init(nums);
        head = sortList(head);
        ListNode.print(head);
    }

    public static void testCase3() {
        int[] nums = {};
        ListNode head = ListNode.init(nums);
        head = sortList(head);
        ListNode.print(head);
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
        testCase3();
    }

}
