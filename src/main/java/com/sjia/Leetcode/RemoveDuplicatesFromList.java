package com.sjia.Leetcode;



public class RemoveDuplicatesFromList {
    //  #83. Remove Duplicates from Sorted List  https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    /*
    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
     */

    // Input: head = [1,1,2]  Output: [1,2]
    // Input: head = [1,1,2,3,3]  Output: [1,2,3]


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        // Create a sorted list: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newHead = deleteDuplicates(head);

        // Print the updated list: 1 -> 2 -> 3
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }


}
