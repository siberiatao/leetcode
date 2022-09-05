package com.siberia.leetcode.listnode;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        if (size < n) {
            return null;
        }
        if (size == n) {
            return head.next;
        }
        ListNode cur = head;
        ListNode pre = cur;
        for (int i = 0; i < size - n; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }

    /**
     * 双指针写法，走天下
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
