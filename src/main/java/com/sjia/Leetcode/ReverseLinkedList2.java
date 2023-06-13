package com.sjia.Leetcode;

public class ReverseLinkedList2 {
    // #92. Reverse Linked List II  https://leetcode.com/problems/reverse-linked-list-ii/

    /*
    Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
    Input: head = [1,2,3,4,5], left = 2, right = 4  Output: [1,4,3,2,5]
    Input: head = [5], left = 1, right = 1  Output: [5]

    1 <= n <= 500
    -500 <= Node.val <= 500
    1 <= left <= right <= n
     */


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before the starting point of the sublist
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode next = curr.next;

        // Reverse the sublist from left to right
        for (int i = 0; i < right - left; i++) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int m = 2;
        int n = 4;

        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        ListNode reversedList = reverseLinkedList2.reverseBetween(head, m, n);

        // Print the reversed linked list: 1 -> 4 -> 3 -> 2 -> 5
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }




}
