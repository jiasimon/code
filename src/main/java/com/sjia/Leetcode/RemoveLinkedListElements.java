package com.sjia.Leetcode;

public class RemoveLinkedListElements {

    // #203 https://leetcode.com/problems/remove-linked-list-elements/
    // Remove all elements from a linked list of integers that have value val

    //Runtime: 1 ms, faster than 93.29% of Java online submissions for Remove Linked List Elements.
    //Memory Usage: 46.4 MB, less than 5.24% of Java online submissions for Remove Linked List Elements.

    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode pre = fakeHead, current=head;
        while (current !=null) {
            if (current.val == val) pre.next = current.next;
            else {
                pre = current;

            }
            current = current.next;
        }
        return fakeHead.next;

    }


}
