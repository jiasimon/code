package com.sjia.Leetcode;

public class BSTreeLCA {
    // #235. Lowest Common Ancestor of a Binary Search Tree
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    /*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
     */


    // Runtime: 11 ms, faster than 8.49% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    //Memory Usage: 47.8 MB, less than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.

    // Runtime: 6 ms, faster than 40.20% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    //Memory Usage: 47.5 MB, less than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.

    // recursive
    // 6 ms, 97.37%; 44.1 MB, 52.31%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }


}
