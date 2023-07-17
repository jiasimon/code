package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    // #199. Binary Tree Right Side View    https://leetcode.com/problems/binary-tree-right-side-view/
    /*
    Given the root of a binary tree, imagine yourself standing on the right side of it,
    return the values of the nodes you can see ordered from top to bottom.

    Input: root = [1,2,3,null,5,null,4]     Output: [1,3,4]
    Input: root = [1,null,3]                Output: [1,3]
    The number of nodes in the tree is in the range [0, 100].
     */


    // BFS, refer to #102. Binary Tree Level Order Traversal
    // 1ms, 66.69% ; 41.79mb, 11.20%
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while( !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size -1) res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return res;

    }




}
