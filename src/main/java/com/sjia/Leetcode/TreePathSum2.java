package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum2 {
    // #113 https://leetcode.com/problems/path-sum-ii/
    // Given a binary tree and a sum, find all root-to-leaf paths
    // where each path's sum equals the given sum.


    // Runtime: 1 ms, faster than 99.89% of Java online submissions for Path Sum II.
    //Memory Usage: 40 MB, less than 41.73% of Java online submissions for Path Sum II.


    // use common backtrack code, Runtime: 1 ms, faster than 99.89% of Java online submissions for Path Sum II.
    //Memory Usage: 39.8 MB, less than 68.40% of Java online submissions for Path Sum II.

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        List <Integer> tmp = new ArrayList<Integer>();
        treePathSum ( root, sum, result, tmp);
        return result;
    }

    public void treePathSum(TreeNode root, int sum, List<List<Integer>> result, List <Integer> path) {
        if (root == null) return;
        path.add(root.val);

        if (root.left==null & root.right==null && sum == root.val ) {
            result.add(new ArrayList<Integer> (path));
            path.remove(path.size()-1);
            return;
        } else {
            treePathSum(root.left, sum - root.val, result, path);
            treePathSum(root.right, sum - root.val, result, path);
        }
        path.remove(path.size()-1);
    }

}
