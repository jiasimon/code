package com.sjia.Leetcode;

public class SubtreeAnotherTree {
    // #572. Subtree of Another Tree    https://leetcode.com/problems/subtree-of-another-tree/description/

    /*
    A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

    Input: root = [3,4,5,1,2], subRoot = [4,1,2]    Output: true

    Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]  Output: false

    The number of nodes in the root tree is in the range [1, 2000].
    The number of nodes in the subRoot tree is in the range [1, 1000]
    -10^4 <= root.val <= 10^4
     */

    // recursive , 6ms, 7.37%; 43.98, 87.93%
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }


    // 2ms, 96.02%
    public boolean isSubtree_faster(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot)){
            return true;
        }


        if ( root == null) {
            return false;
        }


        return isSubtree_faster(root.left, subRoot) || isSubtree_faster(root.right, subRoot);
    }

    public static void main(String[] args) {
        SubtreeAnotherTree solution = new SubtreeAnotherTree();

        // Test case: creating two sample trees
        TreeNode s = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)),
                new TreeNode(5));

        TreeNode t = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));

        System.out.println("Test Case 1: " + solution.isSubtree(s, t)); // Output: true
    }


}
