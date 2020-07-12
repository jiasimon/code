package com.sjia.Leetcode;

public class RemoveNodeFromEnd {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    // #19 https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
    //Memory Usage: 39.7 MB, less than 6.50% of Java online submissions for Remove Nth Node From End of List.


    //[1,2,3,4,5]
    //2

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        //if remove the first node
        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }


}
