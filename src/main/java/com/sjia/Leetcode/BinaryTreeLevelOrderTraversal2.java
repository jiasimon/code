package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {
    // #107. Binary Tree Level Order Traversal II   https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

    /*
    Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
    Input: root = [3,9,20,null,null,15,7]   Output: [[15,7],[9,20],[3]]
    Input: root = [1]   Output: [[1]]

     */

    // LinkedList, result.add(0, currentLevel)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(0, currentLevel);
        }

        return result;
    }



}
