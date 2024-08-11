package com.sjia.Leetcode600;

public class LongestUnivaluePath {
    // #687. Longest Univalue Path  https://leetcode.com/problems/longest-univalue-path/description/
    /*
    Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

    The length of the path between two nodes is represented by the number of edges between them.

    Input: root = [5,4,5,1,1,null,5]    Output: 2
     */

    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        longestPath(root);
        return maxLength;
    }

    private int longestPath(TreeNode node) {
        if (node == null) return 0;

        int left = longestPath(node.left);
        int right = longestPath(node.right);

        int leftPath = 0, rightPath = 0;

        if (node.left != null && node.left.val == node.val) {
            leftPath = left + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            rightPath = right + 1;
        }

        maxLength = Math.max(maxLength, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }

    public static TreeNode createTree(Integer[] array, int index) {
        TreeNode root = null;
        if (index < array.length && array[index] != null) {
            root = new TreeNode(array[index]);
            root.left = createTree(array, 2 * index + 1);
            root.right = createTree(array, 2 * index + 2);
        }
        return root;
    }

    public static void main(String[] args) {
        LongestUnivaluePath solution = new LongestUnivaluePath();

        // Test Case 1
        Integer[] array1 = {5, 4, 5, 1, 1, null, 5};
        TreeNode root1 = createTree(array1, 0);
        System.out.println("Test Case 1: " + solution.longestUnivaluePath(root1)); // Output: 2

        // Test Case 2
        Integer[] array2 = {1, 4, 5, 4, 4, null, 5};
        TreeNode root2 = createTree(array2, 0);
        System.out.println("Test Case 2: " + solution.longestUnivaluePath(root2)); // Output: 2

        // Test Case 3
        Integer[] array3 = {1, null, 1, 1, 1, 1, 1};
        TreeNode root3 = createTree(array3, 0);
        System.out.println("Test Case 3: " + solution.longestUnivaluePath(root3)); // Output: 2
    }

}
