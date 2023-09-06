package com.sjia.Leetcode;

public class SplitLinkedListInParts725 {
    // #725. Split Linked List in Parts     https://leetcode.com/problems/split-linked-list-in-parts/?envType=daily-question&envId=2023-09-06

    /*
    Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

    The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

    The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

    Return an array of the k parts.

    Input: head = [1,2,3], k = 5        Output: [[1],[2],[3],[],[]]

    Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3     Output: [[1,2,3,4],[5,6,7],[8,9,10]]

    1 <= k <= 50
    0 <= Node.val <= 1000
     */




    // i < largerParts ? 1 : 0
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Calculate the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Determine the size of each part and the number of larger parts
        int partSize = length / k;
        int largerParts = length % k;

        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            int size = partSize + (i < largerParts ? 1 : 0); // Adjust size for larger parts
            if (size == 0) {
                result[i] = null;
                continue;
            }

            result[i] = current; // Start of the current part
            ListNode prev = null;

            // Traverse the current part and set its end to null
            for (int j = 0; j < size; j++) {
                prev = current;
                current = current.next;
            }

            if (prev != null) {
                prev.next = null; // Cut off the current part
            }
        }

        return result;
    }






    //
    // 0 ms, 100%; 43.9 MB,14.33%
    public ListNode[] splitListToParts_newlist(ListNode head, int k) {
        int length =0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int groupSize = length / k;
        int largerGroup = length % k;

        ListNode[] result = new ListNode[k];
        current = head;

        for ( int i = 0 ; i < k; i++) {

            int size = 0;
            if (i < largerGroup) {
                size = groupSize + 1;
            } else {
                size = groupSize;
            }


            result[i] = current; // Start of the current part
            ListNode prev = null;

            for (int j = 0; j < size; j++) {
                prev = current;
                current = current.next;
            }
            if (prev != null) {
                prev.next = null; // Cut off the current part
            }

        }

        return result;

    }


    // Helper function to convert an array of linked lists to a string for testing
    private static String linkedListsToString(ListNode[] lists) {
        StringBuilder sb = new StringBuilder();
        for (ListNode list : lists) {
            sb.append("[");
            while (list != null) {
                sb.append(list.val);
                list = list.next;
                if (list != null) {
                    sb.append(", ");
                }
            }
            sb.append("], ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SplitLinkedListInParts725 solution = new SplitLinkedListInParts725();

        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 7;

        ListNode[] result = solution.splitListToParts_newlist(head, k);
        System.out.println("Split Linked List in Parts: " + linkedListsToString(result));
    }




}
