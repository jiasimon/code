package com.sjia.Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTreeLevelTraversal {

    // #107 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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


}
