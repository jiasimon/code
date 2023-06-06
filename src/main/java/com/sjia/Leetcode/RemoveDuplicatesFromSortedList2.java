package com.sjia.Leetcode;

public class RemoveDuplicatesFromSortedList2 {
    // #82. Remove Duplicates from Sorted List II  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

    /*
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
     */

    // The number of nodes in the list is in the range [0, 300].
    // -100 <= Node.val <= 100
    // Input: head = [1,2,3,3,4,4,5]  Output: [1,2,5]
    // Input: head = [1,1,1,2,3]  Output: [2,3]



    // dummy , prev, curr
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            // if no duplicates, move prev Node
            if (prev.next == curr) {
                prev = prev.next;
            } else {  // skip all duplicates to next
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create a sorted list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode newHead = deleteDuplicates(head);

        // Print the updated list: 1 -> 2 -> 5
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

}
