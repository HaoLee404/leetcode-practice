package org.lee.leetcode.num141_160;

import java.util.HashMap;

public class LC146_LRUCache {

    public static class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;
        ListNode() {}
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final ListNode hair = new ListNode();

    private final ListNode tail = new ListNode();

    private final int capacity;

    private int size;

    private final HashMap<Integer, ListNode> map;

    public LC146_LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        hair.next = tail;
        tail.prev = hair;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new ListNode(key, value);
            setNewHead(node);
            map.put(key, node);
            size++;
        }
        if (size > capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        setNewHead(node);
    }

    private void setNewHead(ListNode node) {
        node.next = hair.next;
        node.next.prev = node;
        hair.next = node;
        node.prev = hair;
    }

    public static void testCase() {
        //5 4 1
        LC146_LRUCache cache = new LC146_LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.get(3) == 3);
        System.out.println(cache.get(1) == 1);
        cache.put(4, 4);
        System.out.println(cache.get(2) == -1);
        cache.put(5, 5);
        System.out.println(cache.get(3) == -1);
    }

    public static void main(String[] args) {
        testCase();
    }

}
