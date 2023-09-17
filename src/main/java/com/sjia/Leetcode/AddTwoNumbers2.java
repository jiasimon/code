package com.sjia.Leetcode;

public class AddTwoNumbers2 {
    // #445. Add Two Numbers II     https://leetcode.com/problems/add-two-numbers-ii/description/

    /*
    You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: l1 = [7,2,4,3], l2 = [5,6,4]     Output: [7,8,0,7]
    Input: l1 = [2,4,3], l2 = [5,6,4]       Output: [8,0,7]

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Reverse both input lists
        ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);

        ListNode dummyHead = new ListNode(); // Dummy head of the result list
        ListNode current = dummyHead;
        int carry = 0;

        while (reversedL1 != null || reversedL2 != null || carry > 0) {
            int sum = carry;
            if (reversedL1 != null) {
                sum += reversedL1.val;
                reversedL1 = reversedL1.next;
            }
            if (reversedL2 != null) {
                sum += reversedL2.val;
                reversedL2 = reversedL2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            current.next = new ListNode(sum);
            current = current.next;
        }

        // Reverse the result list back
        ListNode result = reverseList(dummyHead.next);

        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        AddTwoNumbers2 solution = new AddTwoNumbers2();

        // Example 1:
        // Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        // Output: 7 -> 8 -> 0 -> 7
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }


}
