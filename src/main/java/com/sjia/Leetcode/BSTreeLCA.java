package com.sjia.Leetcode;

public class BSTreeLCA {
    // #235. Lowest Common Ancestor of a Binary Search Tree
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    /*
    LowestCommonAncestorBST : BSTreeLCA
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



    // iterative
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }

        }
        return null;
    }


    public static void main(String[] args) {
        BSTreeLCA lcaBST = new BSTreeLCA();

        // Create a Binary Search Tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.left.right.right; // Node with value 5

        TreeNode lowestCommonAncestor = lcaBST.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lowestCommonAncestor.val); // Output: 2
    }

}
