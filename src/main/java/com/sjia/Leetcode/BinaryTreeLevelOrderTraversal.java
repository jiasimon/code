package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // #102. Binary Tree Level Order Traversal  https://leetcode.com/problems/binary-tree-level-order-traversal/

    /*
    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
    Input: root = [3,9,20,null,null,15,7]   Output: [[3],[9,20],[15,7]]
    Input: root = [1]   Output: [[1]]
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(levelNodes);
        }

        return result;
    }


    // recursive
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        levelTraversal(res, root, 0);
        return res;
    }

    private void levelTraversal(List<List<Integer>> resultList, TreeNode root, int level) {
        if (root == null) return ;
        if ( level >= resultList.size() ) {
            resultList.add(new LinkedList<Integer>());
        }
        resultList.get(level).add(root.val);
        levelTraversal(resultList,root.left, level+1);
        levelTraversal(resultList,root.right, level+1);
    }


    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

        // Example tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        List<List<Integer>> levelOrderTraversal = solution.levelOrder(root);
        List<List<Integer>> levelOrderTraversal = solution.levelOrderRecursive(root);
        System.out.println("Level order traversal: " + levelOrderTraversal);
    }


}
