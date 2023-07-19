package com.sjia.Leetcode;

public class RemoveLinkedListElements {

    // #203. Remove Linked List Elements https://leetcode.com/problems/remove-linked-list-elements/
    // Remove all elements from a linked list of integers that have value val

    /*
    Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
    Input: head = [1,2,6,3,4,5,6], val = 6  Output: [1,2,3,4,5]
    Input: head = [], val = 1   Output: []
    Input: head = [7,7,7,7], val = 7    Output: []

     */

    //Runtime: 1 ms, faster than 93.29% of Java online submissions for Remove Linked List Elements.
    //Memory Usage: 46.4 MB, less than 5.24% of Java online submissions for Remove Linked List Elements.

    // iterative with pre pointer
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, current=head;
        while (current !=null) {
            if (current.val == val) pre.next = current.next;
            else {
                pre = current;
            }
            current = current.next;
        }
        return dummy.next;

    }



    // recursive,
    /*
    When the input node is an empty node, then there is nothing to delete, so we just return a null node back. (That's the first line)
    When the head of the input node is the target we want to delete, we just return head.next instead of head to skip it. (That's the third line), else we will return head.
    apply the same thing to every other node until it reaches null. (That's the second line).
     */
    public static ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRecursive(head.next, val);
        return head.val == val ? head.next : head;
    }



    public static void main(String[] args) {
        // Test Case 1: Remove all occurrences of 2 from the linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 2
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        int val1 = 2;
        ListNode result1 = removeElementsRecursive(head1, val1);

        System.out.print("After removing " + val1 + ": ");
        printLinkedList(result1);

        // Test Case 2: Remove all occurrences of 3 from the linked list: 3 -> 1 -> 3 -> 2 -> 3 -> 4 -> 5
        ListNode head2 = new ListNode(3);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(2);
        ListNode node10 = new ListNode(3);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(5);

        head2.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;

        int val2 = 3;
        ListNode result2 = removeElements(head2, val2);

        System.out.print("After removing " + val2 + ": ");
        printLinkedList(result2);
    }

    // Helper method to print the linked list
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
