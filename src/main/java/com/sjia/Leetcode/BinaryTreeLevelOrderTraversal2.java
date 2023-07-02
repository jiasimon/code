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



    // recursive
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();

        levelTraversal(resultList, root, 0);
        return resultList;
    }

    private void levelTraversal(List<List<Integer>> resultList, TreeNode root, int level) {
        if (root == null) return ;
        if ( level >= resultList.size() ) {
            resultList.add(0, new LinkedList<Integer>());
        }
        levelTraversal(resultList,root.left, level+1);
        levelTraversal(resultList,root.right, level+1);
        resultList.get(resultList.size()-level-1).add(root.val);
    }



    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal2 solution = new BinaryTreeLevelOrderTraversal2();

        // Example tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> levelOrderTraversal = solution.levelOrderBottom2(root);
        System.out.println("Level order traversal: " + levelOrderTraversal);
    }


}
