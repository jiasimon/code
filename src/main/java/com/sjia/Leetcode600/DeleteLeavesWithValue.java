package com.sjia.Leetcode600;



public class DeleteLeavesWithValue {
    // #1325. Delete Leaves With a Given Value
    // https://leetcode.com/problems/delete-leaves-with-a-given-value/description/?envType=daily-question&envId=2024-05-17

    /*
    Input: root = [1,2,null,2,null,2], target = 2   Output: [1]
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }



    // Helper method to create a binary tree from array
    public static TreeNode createTree(Integer[] array, int index) {
        TreeNode root = null;
        if (index < array.length && array[index] != null) {
            root = new TreeNode(array[index]);
            root.left = createTree(array, 2 * index + 1);
            root.right = createTree(array, 2 * index + 2);
        }
        return root;
    }

    // Helper method to print the binary tree (for testing purposes)
    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        DeleteLeavesWithValue solution = new DeleteLeavesWithValue();

        // Test Case
        Integer[] array = {1, 2, 3, 2, null, 2, 4};
        TreeNode root = createTree(array, 0);
        int target = 2;
        TreeNode result = solution.removeLeafNodes(root, target);
        printTree(result); // Output: 1 3 null 4
    }

}
