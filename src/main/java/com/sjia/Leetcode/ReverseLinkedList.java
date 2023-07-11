package com.sjia.Leetcode;

import java.util.List;

public class ReverseLinkedList {
    // #206. Reverse Linked List https://leetcode.com/problems/reverse-linked-list/

    /*
    Given the head of a singly linked list, reverse the list, and return the reversed list.
    Input: head = [1,2,3,4,5]   Output: [5,4,3,2,1]
     */


    // iterative, Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    //Memory Usage: 40.5 MB, less than 5.01% of Java online submissions for Reverse Linked List.
/*    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }*/

    // recursive Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    //Memory Usage: 40.7 MB, less than 5.01% of Java online submissions for Reverse Linked List.
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }


    // iterative, use another currentNode so head will not be changed
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode tmpNext = current.next;
            current.next = pre;
            pre = current;
            current = tmpNext;
        }
        return pre;
    }


    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Test case: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode reversedHead = solution.reverseList(head);

        // Print the reversed linked list
        printList(reversedHead);
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
