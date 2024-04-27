package com.sjia.Leetcode;

public class AddOneRowToTree {
    // #623. Add One Row to Tree    https://leetcode.com/problems/add-one-row-to-tree/description/
    /*
    Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

    Note that the root node is at depth 1.
     */

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        insertRow(root, v, d, 1);
        return root;
    }

    private void insertRow(TreeNode node, int v, int d, int depth) {
        if (node == null) return;

        if (depth == d - 1) {
            TreeNode leftChild = node.left;
            TreeNode rightChild = node.right;
            node.left = new TreeNode(v);
            node.right = new TreeNode(v);
            node.left.left = leftChild;
            node.right.right = rightChild;
        } else {
            insertRow(node.left, v, d, depth + 1);
            insertRow(node.right, v, d, depth + 1);
        }
    }


    public static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        AddOneRowToTree solution = new AddOneRowToTree();

        // Test Case
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        int v = 1, d = 2;
        System.out.println("Test Case 1:");
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();
        System.out.println("After adding one row with value " + v + " at depth " + d + ":");
        TreeNode modifiedRoot = solution.addOneRow(root, v, d);
        printTree(modifiedRoot); 
    }
}
