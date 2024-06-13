package com.sjia.Leetcode600;

public class TrimBinarySearchTree {
    // #669. Trim a Binary Search Tree  https://leetcode.com/problems/trim-a-binary-search-tree/description/
    /*
    Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

    Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

    Input: root = [1,0,2], low = 1, high = 2
    Output: [1,null,2]

    Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
    Output: [3,2,null,1]
    The number of nodes in the tree is in the range [1, 10000].
     */

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public static void main(String[] args) {
        TrimBinarySearchTree solution = new TrimBinarySearchTree();

        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(0);
        root1.right = new TreeNode(2);
        int low1 = 1, high1 = 2;
        TreeNode result1 = solution.trimBST(root1, low1, high1);
        printTree(result1);  // Expected output: 1 2
        System.out.println();

        // Test case 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(0);
        root2.left.right = new TreeNode(2);
        root2.left.right.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        int low2 = 1, high2 = 3;
        TreeNode result2 = solution.trimBST(root2, low2, high2);
        printTree(result2);  // Expected output: 3 2 1
        System.out.println();

        // Test case 3
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(1);
        root3.right = new TreeNode(4);
        int low3 = 2, high3 = 4;
        TreeNode result3 = solution.trimBST(root3, low3, high3);
        printTree(result3);  // Expected output: 3 2 4
        System.out.println();

        // Test case 4
        TreeNode root4 = new TreeNode(1);
        int low4 = 1, high4 = 2;
        TreeNode result4 = solution.trimBST(root4, low4, high4);
        printTree(result4);  // Expected output: 1
        System.out.println();

        // Test case 5
        TreeNode root5 = new TreeNode(2);
        root5.left = new TreeNode(1);
        int low5 = 1, high5 = 1;
        TreeNode result5 = solution.trimBST(root5, low5, high5);
        printTree(result5);  // Expected output: 1
        System.out.println();
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
}
