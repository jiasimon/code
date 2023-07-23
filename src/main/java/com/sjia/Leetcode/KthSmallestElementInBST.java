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
    public int kthSmallestInorder(TreeNode root, int k) {
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



    // countNodes, leftCount, binary Search
    public int kthSmallest(TreeNode root, int k) {
        final int leftCount = countNodes(root.left);

        if (leftCount == k - 1)
            return root.val;
        if (leftCount >= k)
            return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - 1 - leftCount); // LeftCount < k
    }

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }



    public static void main(String[] args) {
        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();

        // Create a Binary Search Tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        System.out.println("Kth smallest element: " + kthSmallestElementInBST.kthSmallest(root, k)); // Output: 1

        k = 3;
        System.out.println("Kth smallest element: " + kthSmallestElementInBST.kthSmallest(root, k)); // Output: 3
    }

}
