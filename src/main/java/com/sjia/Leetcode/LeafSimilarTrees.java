package com.sjia.Leetcode;

public class LeafSimilarTrees {
    // #872 https://leetcode.com/problems/leaf-similar-trees/


    // Runtime: 7 ms, faster than 5.81% of Java online submissions for Leaf-Similar Trees.
    //Memory Usage: 37.6 MB, less than 38.17% of Java online submissions for Leaf-Similar Trees.
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        return helper(root1).equals(helper(root2));
    }

    private String helper(TreeNode root) {
        if (root== null) return "";
        if (root.left== null && root.right == null) return root.val + "-"; // for "1", "2" vs "12"
        return helper(root.left) + helper(root.right);
    }


}
