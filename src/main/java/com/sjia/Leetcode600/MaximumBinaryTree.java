package com.sjia.Leetcode600;

public class MaximumBinaryTree {
    // #654. Maximum Binary Tree    https://leetcode.com/problems/maximum-binary-tree/description/
    /*
    You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

    Create a root node whose value is the maximum value in nums.
    Recursively build the left subtree on the subarray prefix to the left of the maximum value.
    Recursively build the right subtree on the subarray suffix to the right of the maximum value.
    Return the maximum binary tree built from nums.

    Input: nums = [3,2,1,6,0,5]     Output: [6,3,5,null,2,0,null,null,1]
    Input: nums = [3,2,1]           Output: [3,null,2,null,1]

     */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // Find the maximum element and its index
        int maxIdx = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        // Create the root node with the maximum element
        TreeNode root = new TreeNode(nums[maxIdx]);

        // Recursively construct the left and right subtrees
        root.left = construct(nums, left, maxIdx - 1);
        root.right = construct(nums, maxIdx + 1, right);

        return root;
    }

    public static void main(String[] args) {
        // Test case
        int[] nums = {3, 2, 1, 6, 0, 5};

        MaximumBinaryTree solution = new MaximumBinaryTree();
        TreeNode root = solution.constructMaximumBinaryTree(nums);

        System.out.println("Preorder traversal of the constructed Maximum Binary Tree:");
        printPreorder(root);  // Expected output: 6 3 2 1 5 0
    }

    // Helper function to print the tree in preorder traversal
    public static void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

}
