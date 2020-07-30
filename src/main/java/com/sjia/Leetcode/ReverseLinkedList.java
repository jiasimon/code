package com.sjia.Leetcode;

public class ReverseLinkedList {
    // #206 https://leetcode.com/problems/reverse-linked-list/

    // iterative, Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    //Memory Usage: 40.5 MB, less than 5.01% of Java online submissions for Reverse Linked List.

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }


    

}
