package com.sjia.Leetcode;

public class BSTreeLCA {
    // #235 LCA of BST (Lowest Common Ancestor of a Binary Search Tree)
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/


    // Runtime: 11 ms, faster than 8.49% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    //Memory Usage: 47.8 MB, less than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.

    // Runtime: 6 ms, faster than 40.20% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    //Memory Usage: 47.5 MB, less than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int r = root.val, pVal = p.val, qVal = q.val;
        if ( pVal > r && qVal > r) return lowestCommonAncestor(root.right, p,q);
        else if ( pVal < r && qVal < r)  return lowestCommonAncestor(root.left, p,q);
        else return root;
    }


}
