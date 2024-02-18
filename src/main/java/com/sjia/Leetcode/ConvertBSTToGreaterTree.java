package com.sjia.Leetcode;

public class ConvertBSTToGreaterTree {
    // #538. Convert BST to Greater Tree    https://leetcode.com/problems/convert-bst-to-greater-tree/description/

    /*
    Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

    Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
    Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

     */

    int sum = 0;


    // right -> root -> left
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            // Traverse the tree in reverse in-order (right, root, left)
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        ConvertBSTToGreaterTree solution = new ConvertBSTToGreaterTree();

        // Example: Construct the BST: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);

        TreeNode result = solution.convertBST(root);
        System.out.println("Converted BST to Greater Tree");
        solution.printInOrder(result);
    }

    private void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }


}
