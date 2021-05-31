package com.test.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
