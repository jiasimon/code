package com.sjia.Leetcode;

public class ReorderList {
    // #143. Reorder List   https://leetcode.com/problems/reorder-list/description/
    /*

    You may not modify the values in the list's nodes. Only nodes themselves may be changed.
    Input: head = [1,2,3,4]     Output: [1,4,2,3]
    The number of nodes in the list is in the range [1, 5 * 10^4].   1 <= Node.val <= 1000

     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode prev = null;
        ListNode current = slow.next;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        slow.next = null;  // Break the original linked list

        // Step 3: Merge the first half and reversed second half of the linked list
        ListNode p1 = head;
        ListNode p2 = prev;

        while (p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
    }


    public static void main(String[] args) {
        ReorderList solution = new ReorderList();

        // Test case
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        solution.reorderList(head);

        // Print the reordered list
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
