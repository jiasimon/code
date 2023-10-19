package com.sjia.Leetcode;

public class LinkedListCycle {
    // #141. Linked List Cycle  https://leetcode.com/problems/linked-list-cycle/
    /*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
    Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.
     */


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast=head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public boolean hasCycle_tortoise(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;      // Move one step
            hare = hare.next.next;         // Move two steps

            if (tortoise == hare) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle detected
    }


    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Test case 1: No cycle
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head1.next = node2;
        node2.next = node3;
        boolean result1 = solution.hasCycle(head1);
        System.out.println("Has Cycle: " + result1);  // Output: false

        // Test case 2: Cycle exists
        ListNode head2 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        head2.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node4;  // Creates a cycle
        boolean result2 = solution.hasCycle(head2);
        System.out.println("Has Cycle: " + result2);  // Output: true
    }



}
