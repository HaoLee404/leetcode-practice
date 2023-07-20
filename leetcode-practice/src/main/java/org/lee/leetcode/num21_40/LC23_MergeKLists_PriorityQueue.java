package org.lee.leetcode.num21_40;

import org.lee.leetcode.common.ListNode;

import java.util.PriorityQueue;

public class LC23_MergeKLists_PriorityQueue {

    static class Wrapper implements Comparable<Wrapper> {

        ListNode node;

        Wrapper(ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(Wrapper o) {
            return Integer.compare(this.node.val, o.node.val);
        }
    }

    PriorityQueue<Wrapper> queue = new PriorityQueue<>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode n : lists) {
            if (n != null)
                queue.offer(new Wrapper(n));
        }
        ListNode hair = new ListNode(), tail = hair;
        while (!queue.isEmpty()) {
            Wrapper w = queue.poll();
            tail.next = w.node;
            tail = tail.next;
            if (w.node.next != null)
                queue.offer(new Wrapper(w.node.next));
        }
        return hair.next;
    }

}
