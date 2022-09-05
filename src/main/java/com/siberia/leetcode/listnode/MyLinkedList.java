package com.siberia.leetcode.listnode;

public class MyLinkedList {
    private int size;
    private final ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-2);
    }

    public int get(int index) {
        if (size <= index || index < 0) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = new ListNode(val);
        size++;

    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = curNode.next;
        curNode.next = newNode;
        size++;

    }

    public void deleteAtIndex(int index) {
        if (size <= index || index < 0) {
            return;
        }
        ListNode curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        size--;
    }
}
