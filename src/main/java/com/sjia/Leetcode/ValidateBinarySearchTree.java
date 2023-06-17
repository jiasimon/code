package com.sjia.Leetcode;

public class ValidateBinarySearchTree {
    // #98. Validate Binary Search Tree  https://leetcode.com/problems/validate-binary-search-tree/
    /*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left subtree
     of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
     */


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }


    // use Integer instead of int to avoid MIN_VALUE and MAX_VALUE
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        // Example tree: [2,1,3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean isValid = solution.isValidBST(root);
        System.out.println("Is the given tree a valid binary search tree? " + isValid);
    }


}
