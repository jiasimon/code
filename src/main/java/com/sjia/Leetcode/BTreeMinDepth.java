package com.sjia.Leetcode;

public class BTreeMinDepth {

    // #111 https://leetcode.com/problems/minimum-depth-of-binary-tree/

    // [3,9,20,null,null,15,7], [-9,-3,2,null,4,4,0,-6,null,-5]

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
    //Memory Usage: 39.7 MB, less than 18.39% of Java online submissions for Minimum Depth of Binary Tree.

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        if(root.left == null || root.right == null) return m1 + m2 + 1;

        return Math.min(m1,m2) + 1;

    }




}
