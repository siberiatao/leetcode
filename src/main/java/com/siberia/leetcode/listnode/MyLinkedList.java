package com.siberia.leetcode.listnode;

/**
 * 操作链表
 */
public class MyLinkedList {
    private ListNode listNode;

    public MyLinkedList() {
    }

    public int get(int index) {
        int count = 0;
        if (listNode == null) {
            return -1;
        }
        ListNode curNode = listNode;
        while (curNode.next != null && index > count) {
            count++;
            curNode = curNode.next;
        }
        if (index > count) {
            return -1;
        } else {
            return curNode.val;
        }
    }

    public void addAtHead(int val) {
        if (listNode == null) {
            listNode = new ListNode(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = listNode;
        listNode = newNode;

    }

    public void addAtTail(int val) {
        if (listNode == null) {
            listNode = new ListNode(val);
            return;
        }
        if (listNode.next == null) {
            listNode.next = new ListNode(val);
            return;
        }
        ListNode curNode = listNode.next;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = new ListNode(val);
    }

    public void addAtIndex(int index, int val) {
        if (listNode == null) {
            listNode = new ListNode(val);
            return;
        }
        if (listNode.next == null) {
            if (index <= 0) {
                ListNode newNode = new ListNode(val);
                newNode.next = listNode;
                listNode = newNode;
                return;
            }
            if (index == 1) {
                listNode.next = new ListNode(val);
                return;
            }
            return;
        }
        if (index == 1) {
            ListNode newNode = new ListNode(val);
            newNode.next = listNode;
            listNode = newNode;
            return;
        }
        int count = 1;
        ListNode curNode = listNode.next;
        ListNode preNode = listNode;
        while (curNode.next != null) {
            if (count == index) {
                preNode.next = new ListNode(val);
                preNode.next.next = curNode;
                return;
            }
            preNode = curNode;
            curNode = curNode.next;
            count++;
        }
        if (index == count + 1) {
            addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        if (listNode == null) {
            return;
        }
        if (listNode.next == null) {
            if (index == 1) {
                listNode = null;
            }
            return;
        }
        int count = 1;
        ListNode curNode = listNode.next;
        ListNode preNode = listNode;
        while (curNode.next != null) {
            if (count == index) {
                preNode.next = curNode.next;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
            count++;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        myLinkedList.get(4); // 0-->4
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);

        //下一个用例
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
    }
}
