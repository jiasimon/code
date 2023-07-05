package com.sjia.Leetcode;

public class FlattenBinaryTree {
    // #114. Flatten Binary Tree to Linked List  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    /*
        Given the root of a binary tree, flatten the tree into a "linked list":

        The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
        The "linked list" should be in the same order as a pre-order traversal of the binary tree.
        Input: root = [1,2,5,3,4,null,6]    Output: [1,null,2,null,3,null,4,null,5,null,6]
        The number of nodes in the tree is in the range [0, 2000].
        -100 <= Node.val <= 100
     */


    //
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = right;
    }


    private void printTree(TreeNode node) {
        if (node == null) {
//            System.out.print("null ");
            return;
        }

        System.out.print(node.val + " ");
        printTree(node.left);

        printTree(node.right);
    }

    public static void main(String[] args) {
        FlattenBinaryTree solution = new FlattenBinaryTree();

        // Example tree: [1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

//        root.right.left = null;
        root.right.right = new TreeNode(6);


        System.out.print("Original tree: ");
        solution.printTree(root);

        solution.flatten(root);

        System.out.print("flattened tree: ");
        solution.printTree(root);


    }


}
