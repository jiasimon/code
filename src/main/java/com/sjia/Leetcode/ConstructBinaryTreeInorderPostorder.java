package com.sjia.Leetcode;

public class ConstructBinaryTreeInorderPostorder {
    // #106. Construct Binary Tree from Inorder and Postorder Traversal  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    /*
    Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
    Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]   Output: [3,9,20,null,null,15,7]
    Input: inorder = [-1], postorder = [-1]     Output: [-1]
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;
        return buildTreeHelper(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInorder = i;
                break;
            }
        }

        int leftSubtreeSize = rootIndexInorder - inStart;
        root.left = buildTreeHelper(inorder, inStart, rootIndexInorder - 1, postorder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTreeHelper(inorder, rootIndexInorder + 1, inEnd, postorder, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }


}
