package com.sjia.Leetcode;

public class ConstructBinaryTreePreorderInorder {
    // #105. Construct Binary Tree from Preorder and Inorder Traversal  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

    /*
    Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]    Output: [3,9,20,null,null,15,7]
    Input: preorder = [-1], inorder = [-1]  Output: [-1]

    revisit
     */


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        return buildTreeHelper(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInorder = i;
                break;
            }
        }

        int leftSubtreeSize = rootIndexInorder - inStart;
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndexInorder - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndexInorder + 1, inEnd);

        return root;
    }


}
