package com.sjia.Leetcode;

public class SwapNodePairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // #24 Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
    // Memory Usage: 37.2 MB, less than 49.15% of Java online submissions for Swap Nodes in Pairs.



    //  Explained with graph  https://leetcode.com/problems/swap-nodes-in-pairs/solutions/1775033/swapping-nodes-not-just-the-values-visual-explanation-well-explained-c/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
    //Memory Usage: 37.1 MB, less than 63.66% of Java online submissions for Swap Nodes in Pairs.

    // recursive, two nodes a group to swap
    public ListNode swapPairs(ListNode head) {

        // if the list has less than two node left [1,2,3],
        if( (head == null) || (head.next == null) ){
            return head;
        }

        // Nodes to swap
        ListNode secondNode = head.next;

        head.next = swapPairs(secondNode.next);

        secondNode.next = head;

        return secondNode;

    }


    // iterative , dummy node
    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }


}
