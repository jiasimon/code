package com.sjia.Leetcode700;


public class SearchBinarySearchTree {
    // #700. Search in a Binary Search Tree     https://leetcode.com/problems/search-in-a-binary-search-tree/description/
    /*

     */

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        // Construct the BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        SearchBinarySearchTree solution = new SearchBinarySearchTree();

        // Test case: Search for value 2
        int searchVal = 2;
        TreeNode result = solution.searchBST(root, searchVal);

        // Print the output
        if (result != null) {
            System.out.println("Found node with value: " + result.val);
        } else {
            System.out.println("Value not found in the BST");
        }

        // Test case: Search for a value not in the tree (e.g., 5)
        searchVal = 5;
        result = solution.searchBST(root, searchVal);

        if (result != null) {
            System.out.println("Found node with value: " + result.val);
        } else {
            System.out.println("Value not found in the BST");
        }
    }

}
