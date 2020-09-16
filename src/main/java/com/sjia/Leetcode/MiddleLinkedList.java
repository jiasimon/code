package com.sjia.Leetcode;

public class MiddleLinkedList {
    // #876 https://leetcode.com/problems/middle-of-the-linked-list/
    // The number of nodes in the given list will be between 1 and 100.


    // fast and slow two pointer
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    // Memory Usage: 38.4 MB, less than 19.59% of Java online submissions for Middle of the Linked List.
    public ListNode middleNode(ListNode head) {
        ListNode fast =head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
