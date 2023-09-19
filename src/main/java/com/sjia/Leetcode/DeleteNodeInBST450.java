package com.sjia.Leetcode;

public class DeleteNodeInBST450 {
    // #450. Delete Node in a BST   https://leetcode.com/problems/delete-node-in-a-bst/description/

    /*
    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

    Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

    Input: root = [5,3,6,2,4,null,7], key = 3   Output: [5,4,6,2,null,null,7]

    root = [5,3,6,2,4,null,7]
    key = 3

        5
       / \
      3   6
     / \   \
    2   4   7

    Given key to delete is 3. So we find the node with value 3 and delete it.

    One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

        5
       / \
      4   6
     /     \
    2       7

     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // The tree is empty or the key is not found
        }

        // If the key is smaller than the root's value, go left
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If the key is larger than the root's value, go right
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // If the key is found, delete the node
        else {
            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children
            // Get the inorder successor (smallest in the right subtree)
            root.val = findMin(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private int findMin(TreeNode node) {
        int min = node.val;
        while (node.left != null) {
            min = node.left.val;
            node = node.left;
        }
        return min;
    }

    public static void main(String[] args) {
        DeleteNodeInBST450 solution = new DeleteNodeInBST450();

        // Example usage:
        // Construct a sample BST:
        //       5
        //      / \
        //     3   6
        //    / \   \
        //   2   4   7
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        // Delete the node with value 3
        root = solution.deleteNode(root, 3);

        // Print the modified BST
        printInorder(root); // Output: 2 4 5 6 7
    }

    public static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }
}
