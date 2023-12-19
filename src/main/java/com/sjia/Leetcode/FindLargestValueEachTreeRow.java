package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueEachTreeRow {
    // #515. Find Largest Value in Each Tree Row    https://leetcode.com/problems/find-largest-value-in-each-tree-row/

    /*
    Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

          1
         / \
        3   2
       / \   \
      5   3   9
    Input: root = [1,3,2,5,3,null,9]        Output: [1,3,9]

    The number of nodes in the tree will be in the range [0, 10000].
    -2^31 <= Node.val <= 2^31 - 1
     */


    // BFS, Linkedlist
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        FindLargestValueEachTreeRow solution = new FindLargestValueEachTreeRow();

        // Example tree creation for testing
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        List<Integer> largestValues = solution.largestValues(root);
        System.out.println("Largest value in each row: " + largestValues);
    }

}
