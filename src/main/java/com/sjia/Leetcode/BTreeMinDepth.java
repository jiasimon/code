package com.sjia.Leetcode;

public class BTreeMinDepth {

    // #111. Minimum Depth of Binary Tree https://leetcode.com/problems/minimum-depth-of-binary-tree/

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

    // 12 ms , 62.2 MB
    public int minDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If only one of child is non-null, then go into that recursion.
        if (root.left == null) {
            return 1 + minDepthDfs(root.right);
        } else if (root.right == null) {
            return 1 + minDepthDfs(root.left);
        }

        // Both children are non-null, hence call for both childs.
        return 1 + Math.min(minDepthDfs(root.left), minDepthDfs(root.right));
    }


    // 10ms, 61.8 MB
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int L = minDepth2(root.left), R = minDepth2(root.right), m = Math.min(L, R);
        return 1 + (m > 0 ? m : Math.max(L, R));
    }


}
