package com.sjia.Leetcode;

/*
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}*/


public class SortedListBST {
    // #109. Convert Sorted List to Binary Search Tree  https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

    /*
    Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
    height-balanced, binary search tree.
    Input: head = [-10,-3,0,5,9]    Output: [0,-3,9,-10,null,5]
    The number of nodes in head is in the range [0, 2 * 104].
    -10^5 <= Node.val <= 10^5
     */


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return buildBST(head, null);
    }

    // fast, slow pointer to find mid
    private TreeNode buildBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);

        return root;
    }





}
