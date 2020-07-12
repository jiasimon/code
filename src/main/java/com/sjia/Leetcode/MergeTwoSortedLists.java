package com.sjia.Leetcode;

public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // #21 Merge Two Sorted Lists

    // Input: 1->2->4, 1->3->4
    //Output: 1->1->2->3->4->4

    //Runtime: 1 ms, faster than 30.42% of Java online submissions for Merge Two Sorted Lists.
    //Memory Usage: 40.1 MB, less than 15.70% of Java online submissions for Merge Two Sorted Lists.


    //  less line , more memories  Runtime: 1 ms, faster than 30.42% of Java online submissions for Merge Two Sorted Lists.
    //Memory Usage: 40.4 MB, less than 7.86% of Java online submissions for Merge Two Sorted Lists.

/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = (l1.val < l2.val) ? l1 : l2;
        ListNode body = (l1.val < l2.val) ? l2 : l1;
        head.next = mergeTwoLists(head.next, body);
        return head;

    }*/

/*    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }*/



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || (l2 != null && l1.val > l2.val)) {
            ListNode t = l1; l1 = l2; l2 = t;
        }
        if (l1 != null) l1.next = mergeTwoLists(l1.next, l2);
        return l1;

    }


}
