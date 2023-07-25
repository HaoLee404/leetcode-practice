package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.ListNode;

import java.util.LinkedList;

public class LC143_ReorderList_Stack {

    public void reorderList(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        while (true) {
            ListNode n = stack.pop();
            if (curr == n) {
                curr.next = null;
                break;
            }
            ListNode next = curr.next;
            curr.next = n;
            n.next = next;
            curr = next;
            if (curr == n) {
                curr.next = null;
                break;
            }
        }
    }

}
