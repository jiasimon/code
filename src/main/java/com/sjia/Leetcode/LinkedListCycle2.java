package com.sjia.Leetcode;

import java.util.HashSet;

public class LinkedListCycle2 {
    // #142. Linked List Cycle II   https://leetcode.com/problems/linked-list-cycle-ii/description/
    /*
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    Do not modify the linked list.

    Input: head = [3,2,0,-4], pos = 1   Output: tail connects to node index 1
    Input: head = [1,2], pos = 0    Output: tail connects to node index 0
    Input: head = [1], pos = -1     Output: no cycle

    -10^5 <= Node.val <= 10^5
    pos is -1 or a valid index in the linked-list.
     */


    // HashSet
    // 3 ms, 16.80%; 43.2 MB, 88.86%
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (visitedNodes.contains(cur)) {
                return cur;
            } else {
                visitedNodes.add(cur);
                cur = cur.next;
            }
        }
        return null;

    }



}
