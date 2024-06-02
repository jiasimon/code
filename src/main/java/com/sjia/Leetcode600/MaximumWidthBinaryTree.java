package com.sjia.Leetcode600;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthBinaryTree {
    // #662. Maximum Width of Binary Tree   https://leetcode.com/problems/maximum-width-of-binary-tree/description/
    /*
    Given the root of a binary tree, return the maximum width of the given tree.

    The maximum width of a tree is the maximum width among all levels.
     */

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // Minimum index at the current level
            int firstIndex = 0, lastIndex = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.node;
                int index = current.index - minIndex;

                if (i == 0) {
                    firstIndex = index;
                }
                if (i == size - 1) {
                    lastIndex = index;
                }

                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * index + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }

    class Pair<T1, T2> {
        T1 node;
        T2 index;

        Pair(T1 node, T2 index) {
            this.node = node;
            this.index = index;
        }
    }


    public static void main(String[] args) {
        MaximumWidthBinaryTree solution = new MaximumWidthBinaryTree();

        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);
        System.out.println("Test case 1: " + solution.widthOfBinaryTree(root1)); // Expected output: 4

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(5);
        System.out.println("Test case 2: " + solution.widthOfBinaryTree(root2)); // Expected output: 2

        // Test case 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.left.left = new TreeNode(5);
        root3.left.left.left = new TreeNode(6);
        System.out.println("Test case 3: " + solution.widthOfBinaryTree(root3)); // Expected output: 1

        // Test case 4
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(9);
        root4.right.right.right = new TreeNode(7);
        System.out.println("Test case 4: " + solution.widthOfBinaryTree(root4)); // Expected output: 1
    }


}
