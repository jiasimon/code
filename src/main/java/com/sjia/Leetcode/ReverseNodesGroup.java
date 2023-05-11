package com.sjia.Leetcode;

public class ReverseNodesGroup {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // #25 Reverse Nodes in k-Group https://leetcode.com/problems/reverse-nodes-in-k-group/
    //  Compare to #24

    // Given this linked list: 1->2->3->4->5
    //For k = 2, you should return: 2->1->4->3->5
    //For k = 3, you should return: 3->2->1->4->5


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }



}
