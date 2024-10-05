package com.sjia.Leetcode700;

public class InsertBinarySearchTree {
    // #701. Insert into a Binary Search Tree   https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
    /*
    You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

    Input: root = [4,2,7,1,3], val = 5  Output: [4,2,7,1,3,5]


     */


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        // Construct the BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        InsertBinarySearchTree solution = new InsertBinarySearchTree();

        // Test case: Insert value 5 into the BST
        int insertVal = 5;
        TreeNode result = solution.insertIntoBST(root, insertVal);

        // Print the BST in-order to verify insertion
        System.out.print("In-order traversal after insertion: ");
        inOrderTraversal(result);
    }

    // Helper method to perform in-order traversal of the tree
    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

}
