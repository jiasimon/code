package com.sjia.Leetcode;

public class RotateList {
    // #61. Rotate List  https://leetcode.com/problems/rotate-list/description/
    // Given the head of a linked list, rotate the list to the right by k places.
    // Input: head = [1,2,3,4,5], k = 2  Output: [4,5,1,2,3]
    // Input: head = [0,1,2], k = 4  Output: [2,0,1]
    // The number of nodes in the list is in the range [0, 500].
    // 0 <= k <= 2 * 10^9

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = getLength(head);

        k = k % length; // Reduce the rotation count to the range [0, length-1]

        if (k == 0) {
            return head; // No rotation needed
        }

        ListNode fast = head;
        ListNode slow = head;

        // Move the fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Move the fast and slow pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Break the list and rotate
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println("Original list:");
        printList(head);

        ListNode rotated = rotateRight(head, k);

        System.out.println("Rotated list:");
        printList(rotated);
    }


}
