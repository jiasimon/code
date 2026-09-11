package com.sjia.hackerRank2026;

public class MergeTwoSortedLists {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-merge-two-sorted-linked-lists

     class SinglyLinkedListNode {
         int data;
         SinglyLinkedListNode next;
     }

     SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        // 1. Create a dummy node to act as the head of the merged list
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(-1,);
        SinglyLinkedListNode current = dummy;

        // 2. Traverse both lists and attach the smaller value to current.next
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        // 3. Append remaining elements if one list is exhausted before the other
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        // 4. Return the head of the sorted merged list
        return dummy.next;
    }



}
