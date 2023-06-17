package com.sjia.Leetcode;

public class RecoverBinarySearchTree {
    // #99. Recover Binary Search Tree  https://leetcode.com/problems/recover-binary-search-tree/

    /*
    You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
    The number of nodes in the tree is in the range [2, 1000].
    -2^31 <= Node.val <= 2^31 - 1
     */

    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    // InOrder Traversal, first element is always larger than next one, second element is smaller than its previous one
    public void recoverTree(TreeNode root) {
        // Initialize variables
        first = null;
        second = null;
        prev = null;

        // Find the two misplaced nodes
        inorderTraversal(root);

        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        // Check if the current node is misplaced
        if (prev != null && prev.val >= node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;

        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree solution = new RecoverBinarySearchTree();

        // Example tree: [1,3,null,null,2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        System.out.print("Original tree: ");
        solution.printTree(root);

        solution.recoverTree(root);

        System.out.print("Recovered tree: ");
        solution.printTree(root);
    }

    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }

        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }


}
