package com.sjia.Leetcode;

public class SortList {
    // #148. Sort List  https://leetcode.com/problems/sort-list/description/
    /*
    Given the head of a linked list, return the list after sorting it in ascending order.
    Input: head = [4,2,1,3] Output: [1,2,3,4]
    The number of nodes in the list is in the range [0, 5 * 10^4].

     Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)
     */



    // find middle, recursive, merge
    // 12 ms, 55.22%; 56.4 MB, 28.37%
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;


        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }



}
