package com.sjia.Leetcode;

public class CountCompleteTreeNodes {
    // #222. Count Complete Tree Nodes  https://leetcode.com/problems/count-complete-tree-nodes/description/
    /*
    Given the root of a complete binary tree, return the number of the nodes in the tree.

    According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
    and all nodes in the last level are as far left as possible.
     It can have between 1 and 2h nodes inclusive at the last level h.

     Design an algorithm that runs in less than O(n) time complexity.


     */

    // pre-order to count
    int count =0;
    public int countNodes3(TreeNode root) {
        if (root == null) return count;
        count++;
        countNodes3(root.left);
        countNodes3(root.right);
        return count;
    }


    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        return countNodes2(root.left) + countNodes2(root.right) + 1;

    }


    //  2^leftHeight - 1 , (1 << leftHeight) - 1,
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) {
            // If the left and right heights are the same, the tree is a full binary tree
            return (1 << leftHeight) - 1;
        } else {
            // If the left and right heights are different, the tree is not full
            // Calculate the node count recursively for left and right subtrees
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    private int rightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }


    public static void main(String[] args) {
        CountCompleteTreeNodes counter = new CountCompleteTreeNodes();

        // Create a complete binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int result = counter.countNodes(root);
        System.out.println("Number of nodes in the complete tree: " + result); // Output: 6
    }

}
