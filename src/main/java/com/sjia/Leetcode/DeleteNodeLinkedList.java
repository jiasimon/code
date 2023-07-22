package com.sjia.Leetcode;

public class DeleteNodeLinkedList {
    // #237. Delete Node in a Linked List   https://leetcode.com/problems/delete-node-in-a-linked-list/description/
    /*
    There is a singly-linked list head and we want to delete a node node in it.

    You are given the node to be deleted node. You will not be given access to the first node of head.
    All the values of the linked list are unique,
    and it is guaranteed that the given node node is not the last node in the linked list.
    Input: head = [4,5,1,9], node = 5   Output: [4,1,9]
    Input: head = [4,5,1,9], node = 1   Output: [4,5,9]
     */

    // Copy next val, so node becomes prev, then delete the nextNode
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    
}
