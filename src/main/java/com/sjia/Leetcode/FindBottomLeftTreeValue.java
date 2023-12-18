package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    // #513. Find Bottom Left Tree Value    https://leetcode.com/problems/find-bottom-left-tree-value/

    /*
    2
   / \
  1   3
    Input: root = [2,1,3]   Output: 1

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
    Input: root = [1,2,3,4,null,5,6,null,null,7]    Output: 7




     */


    // BFS, Arrays.asList
    // 2 ms, 25.47%; 44.3 MB, 16.95%
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));
        TreeNode node = null;

        while (!q.isEmpty()) {
            node = q.poll();
            if (node.right != null)
                q.offer(node.right);
            if (node.left != null)
                q.offer(node.left);
        }

        return node.val;

    }



    public int findBottomLeftValue_bfs2(TreeNode root) {
        if (root == null) {
            return -1; // or any other default value indicating absence of the tree
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = root.val;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.val; // Update the result for each level
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();

        // Example tree creation for testing
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        int bottomLeftValue = solution.findBottomLeftValue(root);
        System.out.println("Bottom Left Tree Value: " + bottomLeftValue);
    }

}
