package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    // #872 https://leetcode.com/problems/leaf-similar-trees/


    // Runtime: 7 ms, faster than 5.81% of Java online submissions for Leaf-Similar Trees.
    //Memory Usage: 37.6 MB, less than 38.17% of Java online submissions for Leaf-Similar Trees.
/*    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        return helper(root1).equals(helper(root2));
    }

    private String helper(TreeNode root) {
        if (root== null) return "";
        if (root.left== null && root.right == null) return root.val + "-"; // for "1", "2" vs "12"
        return helper(root.left) + helper(root.right);
    }*/


    // use StringBuilder
    // Runtime: 6 ms, faster than 5.81% of Java online submissions for Leaf-Similar Trees.
    //Memory Usage: 39.7 MB, less than 5.00% of Java online submissions for Leaf-Similar Trees.
/*    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        helper(root1, s1);
        helper(root2, s2);
        return s1.toString().equals(s2.toString());
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root== null) return ;
        if (root.left== null && root.right == null) sb.append(root.val + "-");
        helper(root.left,sb);
        helper(root.right,sb);
    }*/


    // Use ArrayList
    // Runtime: 2 ms, faster than 14.19% of Java online submissions for Leaf-Similar Trees.
    //Memory Usage: 39.6 MB, less than 6.13% of Java online submissions for Leaf-Similar Trees.
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        helper(root1, s1);
        helper(root2, s2);
        return s1.toString().equals(s2.toString());
    }

    private void helper(TreeNode root, List<Integer> sb) {
        if (root== null) return ;
        if (root.left== null && root.right == null) sb.add(root.val);
        helper(root.left,sb);
        helper(root.right,sb);
    }



}
