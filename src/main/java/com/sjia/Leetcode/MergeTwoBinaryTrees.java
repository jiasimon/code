package com.sjia.Leetcode;

public class MergeTwoBinaryTrees {
    // #617. Merge Two Binary Trees     https://leetcode.com/problems/merge-two-binary-trees/description/
    /*
    You are given two binary trees root1 and root2.
    Return the merged tree.

    Note: The merging process must start from the root nodes of both trees.

    Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]     Output: [3,4,5,5,4,null,7]

    Input: root1 = [1], root2 = [1,2]       Output: [2,2]
     */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode mergedNode = new TreeNode(t1.val + t2.val);
        mergedNode.left = mergeTrees(t1.left, t2.left);
        mergedNode.right = mergeTrees(t1.right, t2.right);

        return mergedNode;
    }

    // Helper method to print the tree (inorder traversal)
    public static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees solution = new MergeTwoBinaryTrees();

        // Test Case
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        TreeNode mergedTree = solution.mergeTrees(t1, t2);
        System.out.print("Merged Tree: ");
        printTree(mergedTree); // Output: 5 4 4 3 5 7 (in order)   3 4 5 5 4 7 (level)
    }


}
