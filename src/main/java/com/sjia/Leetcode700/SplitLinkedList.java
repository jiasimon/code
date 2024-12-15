package com.sjia.Leetcode700;



public class SplitLinkedList {
    // #725. Split Linked List in Parts     https://leetcode.com/problems/split-linked-list-in-parts/description/
    /*
    Input: head = [1,2,3], k = 5    Output: [[1],[2],[3],[],[]]
    Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3 Output: [[1,2,3,4],[5,6,7],[8,9,10]]

    Calculate the Length:
        Find the total number of nodes in the list, n.

    Determine Part Sizes:
        Each part will have at least n/k nodes.
        The first n % k parts will have an extra node.

    Split the List:
        Traverse the list while splitting it into parts.
        Use a loop to assign nodes to each part based on the calculated sizes.
     */

    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Calculate the length of the list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Determine the size of each part
        int partSize = length / k;
        int extraNodes = length % k;

        // Step 3: Create the result array
        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            // Assign the head of the current part
            ListNode partHead = current;
            result[i] = partHead;

            // Determine the size of the current part
            int currentPartSize = partSize + (i < extraNodes ? 1 : 0);

            // Traverse the nodes for the current part
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }

            // Break the connection to the next part
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // Utility function to print the list parts
    public static void printListParts(ListNode[] parts) {
        for (ListNode part : parts) {
            ListNode current = part;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }


    public static void main(String[] args) {
        SplitLinkedList solution = new SplitLinkedList();

        // Test Case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode[] result1 = solution.splitListToParts(head1, 3);
        printListParts(result1);
        // Output: [1 -> 2 -> null, 3 -> 4 -> null, 5 -> null]

        // Test Case 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        ListNode[] result2 = solution.splitListToParts(head2, 5);
        printListParts(result2);
        // Output: [1 -> null, 2 -> null, null, null, null]
    }


}
