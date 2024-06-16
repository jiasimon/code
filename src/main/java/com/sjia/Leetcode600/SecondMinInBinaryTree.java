package com.sjia.Leetcode600;

public class SecondMinInBinaryTree {
    // #671. Second Minimum Node In a Binary Tree   https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
    /*
    Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
    Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
    If no such second minimum value exists, output -1 instead.

    1 <= Node.val <= 2^31 - 1
    The number of nodes in the tree is in the range [1, 25]
    root.val == min(root.left.val, root.right.val) for each internal node of the tree
     */

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return findSecondMin(root, root.val);
    }

    private int findSecondMin(TreeNode root, int firstMin) {
        if (root == null) {
            return -1;
        }
        if (root.val != firstMin) {
            return root.val;
        }
        int leftSecondMin = findSecondMin(root.left, firstMin);
        int rightSecondMin = findSecondMin(root.right, firstMin);

        if (leftSecondMin == -1) {
            return rightSecondMin;
        }
        if (rightSecondMin == -1) {
            return leftSecondMin;
        }

        return Math.min(leftSecondMin, rightSecondMin);
    }

    public static void main(String[] args) {
        SecondMinInBinaryTree solution = new SecondMinInBinaryTree();

        // Test case 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println("Test case 1: " + solution.findSecondMinimumValue(root1));  // Expected output: 5

        // Test case 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println("Test case 2: " + solution.findSecondMinimumValue(root2));  // Expected output: -1

        // Test case 3
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        System.out.println("Test case 3: " + solution.findSecondMinimumValue(root3));  // Expected output: 3

        // Test case 4
        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(5);
        root4.right.left = new TreeNode(2);
        root4.right.right = new TreeNode(7);
        System.out.println("Test case 4: " + solution.findSecondMinimumValue(root4));  // Expected output: 5

        // Test case 5
        TreeNode root5 = new TreeNode(5);
        root5.left = new TreeNode(8);
        root5.right = new TreeNode(5);
        root5.left.left = new TreeNode(8);
        root5.left.right = new TreeNode(9);
        root5.right.right = new TreeNode(10);
        System.out.println("Test case 5: " + solution.findSecondMinimumValue(root5));  // Expected output: 8
    }

}
