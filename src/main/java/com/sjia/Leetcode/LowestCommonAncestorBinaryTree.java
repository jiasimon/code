package com.sjia.Leetcode;

public class LowestCommonAncestorBinaryTree {
    // #236. Lowest Common Ancestor of a Binary Tree https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/  #fb
    // The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
    // (where we allow a node to be a descendant of itself).”


    /*
         The number of nodes in the tree is in the range [2, 105].
         -10^9 <= Node.val <= 10^9
         All Node.val are unique.
         p != q
         p and q will exist in the tree.
     */




    // left != null && right !=null
    // Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    //Memory Usage: 41.4 MB, less than 27.49% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right !=null ) return root;
        else if (left != null ) return left;
        else return right;

    }


    // Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    //Memory Usage: 41 MB, less than 73.30% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
/*    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
    */


}
