package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    // #230. Kth Smallest Element in a BST  https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    /*
    Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

    Input: root = [3,1,4,null,2], k = 1     Output: 1

    Input: root = [5,3,6,2,4,null,null,1], k = 3    Output: 3
    1 <= k <= n <= 10000

     */

    int count = 0;
    int result = 0;

    // recursive, inorderTraversal
    // 0ms 100.00% ; 44.07mb, 78.96%
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorderTraversal(root, k);
        return result;
    }



    public void inorderTraversal(TreeNode root, int k) {
        if (root != null) {
            inorderTraversal(root.left, k);
            count++;
            if (count == k) {
                result = root.val;
                return;
            }
            inorderTraversal(root.right, k);
        }
    }



}
