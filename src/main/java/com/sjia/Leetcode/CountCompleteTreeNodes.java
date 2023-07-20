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
    public int countNodes(TreeNode root) {
        if (root == null) return count;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
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
