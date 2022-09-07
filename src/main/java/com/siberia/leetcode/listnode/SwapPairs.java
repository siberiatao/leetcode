package com.siberia.leetcode.listnode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            ListNode temp1 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp;
            cur.next.next.next = temp1;
            cur = cur.next.next;
        }
        return dummyNode.next;
    }
}
