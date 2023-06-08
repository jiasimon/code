package com.sjia.Leetcode;

public class PartitionList {
    // #86. Partition List  https://leetcode.com/problems/partition-list/
    /*
    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    Input: head = [1,4,3,2,5,2], x = 3  Output: [1,2,2,4,3,5]
    Input: head = [2,1], x = 2  Output: [1,2]

    The number of nodes in the list is in the range [0, 200].
    -100 <= Node.val <= 100
    -200 <= x <= 200

     */


    // separate into two lists then join, dummy Nodes

    public static ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode smallerTail = smallerHead;
        ListNode greaterHead = new ListNode(0);
        ListNode greaterTail = greaterHead;

        while (head != null) {
            if (head.val < x) {
                smallerTail.next = head;
                smallerTail = smallerTail.next;
            } else {
                greaterTail.next = head;
                greaterTail = greaterTail.next;
            }
            head = head.next;
        }

        greaterTail.next = null;
        smallerTail.next = greaterHead.next;

        return smallerHead.next;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int x = 3;
        ListNode newHead = partition(head, x);

        // Print the updated list: 1 -> 2 -> 2 -> 4 -> 3 -> 5
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

}
