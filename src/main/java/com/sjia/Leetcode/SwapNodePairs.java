package com.sjia.Leetcode;

public class SwapNodePairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // #24 https://leetcode.com/problems/swap-nodes-in-pairs/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
    // Memory Usage: 37.2 MB, less than 49.15% of Java online submissions for Swap Nodes in Pairs.


    // remove "ListNode firstNode = head;"
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
    //Memory Usage: 37.1 MB, less than 63.66% of Java online submissions for Swap Nodes in Pairs.

    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode secondNode = head.next;

        // Swapping
        head.next  = swapPairs(secondNode.next);
        secondNode.next = head;

        // Now the head is the second node
        return secondNode;
    }


}
