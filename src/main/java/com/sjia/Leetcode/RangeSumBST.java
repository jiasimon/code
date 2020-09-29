package com.sjia.Leetcode;

public class RangeSumBST {
    // #938 https://leetcode.com/problems/range-sum-of-bst/
    // The number of nodes in the tree is at most 10000.
    // The final answer is guaranteed to be less than 2^31.


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
    //Memory Usage: 47 MB, less than 89.46% of Java online submissions for Range Sum of BST.
/*

    int res=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return res;
    }

    private void helper(TreeNode root, int L, int R) {
        if (root != null) {
            if ( root.val >= L && root.val <= R ) {
                res += root.val;
            }
            if (root.val > L  ) {
                helper( root.left, L, R);
            }
            if (root.val < R ) {
                helper( root.right, L, R);
            }
        }
    }
*/

    // Runtime: 1 ms, faster than 53.10% of Java online submissions for Range Sum of BST.
    //Memory Usage: 47.3 MB, less than 63.21% of Java online submissions for Range Sum of BST.
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0; // base case.
        return (L <= root.val && root.val <= R ? root.val : 0)
                + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }


}
