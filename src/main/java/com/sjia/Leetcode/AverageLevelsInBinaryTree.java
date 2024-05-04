package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsInBinaryTree {
    // #637. Average of Levels in Binary Tree   https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

    /*
    Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

    Input: root = [3,9,20,null,null,15,7]   Output: [3.00000,14.50000,11.00000]

    Input: root = [3,9,20,15,7]             Output: [3.00000,14.50000,11.00000]

     */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null) return averages;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            averages.add(sum / size);
        }

        return averages;
    }


    public static TreeNode createTree(Integer[] array, int index) {
        TreeNode root = null;
        if (index < array.length && array[index] != null) {
            root = new TreeNode(array[index]);
            root.left = createTree(array, 2 * index + 1);
            root.right = createTree(array, 2 * index + 2);
        }
        return root;
    }

    public static void main(String[] args) {
        AverageLevelsInBinaryTree solution = new AverageLevelsInBinaryTree();

        // Test Case
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = createTree(array, 0);
        List<Double> result = solution.averageOfLevels(root);
        System.out.println("Test Case 1: " + result); // Output: [3.0, 14.5, 11.0]
    }
}
