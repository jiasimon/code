package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum2 {
    // #113. Path Sum II  https://leetcode.com/problems/path-sum-ii/
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
//            path.remove(path.size()-1);
//            return;
        } else {
            treePathSum(root.left, sum - root.val, result, path);
            treePathSum(root.right, sum - root.val, result, path);
        }
        path.remove(path.size()-1);
    }



    //  add test cases
    public static void main(String[] args) {
        TreePathSum2 solution = new TreePathSum2();

        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        // root = [5,4,8,11,null,13,4,7,2,null,null,5,1]  targetSum = 22
        // Output: [[5,4,11,2],[5,8,4,5]]
        System.out.print("pathSum tree: " + solution.pathSum(root,22));


    }



}
