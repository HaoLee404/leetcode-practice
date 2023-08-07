package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.ListNode;

public class LC148_SortList_TopToBottom {

    public static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null)
            return null;
        if (head == tail)
            return head;
        ListNode fast = head, mid = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            mid = mid.next;
        }
        ListNode midNext = mid.next;
        mid.next = null;
        if (tail != null)
            tail.next = null;

        return merge2Lists(sortList(head, mid), sortList(midNext, tail));
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
        int[] nums = {2,3,1,5,4};
        ListNode head = ListNode.init(nums);
        head = sortList(head);
        ListNode.print(head);
    }

    public static void main(String[] args) {
        testCase();
    }

}
