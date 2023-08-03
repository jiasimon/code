package com.sjia.Leetcode;

public class OddEvenLinkedList {
    // #328. Odd Even Linked List   https://leetcode.com/problems/odd-even-linked-list/
    /*
    The first node is considered odd, and the second node is even, and so on.

    Note that the relative order inside both the even and odd groups should remain as it was in the input.

    You must solve the problem in O(1) extra space complexity and O(n) time complexity.
    Given 1->2->3->4->5->NULL,
    return 1->3->5->2->4->NULL.

    Input: head = [1,2,3,4,5]   Output: [1,3,5,2,4]
    Input: head = [2,1,3,5,6,4,7]   Output: [2,3,6,7,1,5,4]

     */

    public ListNode oddEvenList(ListNode head) {
        if (head == null ) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while ( even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    // Helper function to create a linked list from an array
    private ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    // Helper function to print a linked list
    private void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = solution.createLinkedList(nums);
        System.out.println("Original Linked List:");
        solution.printLinkedList(head);

        ListNode newHead = solution.oddEvenList(head);

        System.out.println("Odd-Even Linked List:");
        solution.printLinkedList(newHead);
    }


}
