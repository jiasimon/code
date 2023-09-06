package com.sjia.Leetcode;

public class LowestCommonAncestorDeepestLeaves {
    // #1123. Lowest Common Ancestor of Deepest Leaves  https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

    /*
    Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

    Recall that:

    The node of a binary tree is a leaf if and only if it has no children
    The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
    The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.


     */


    // root, left, right
    // 0 ms, 100%; 43.5 MB, 30.5%
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null) return null;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(left==right) return root;
        else if(left<right) return lcaDeepestLeaves(root.right);
        return lcaDeepestLeaves(root.left);

    }

    // refer to #104 maxdepth
    int dfs(TreeNode  node){
        if(node==null) return 0;
        return 1+Math.max(dfs(node.right),dfs(node.left));
    }


}
