package com.sjia.Leetcode;

public class SameTree {
    // #100 https://leetcode.com/problems/same-tree/




    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
    //Memory Usage: 38.5 MB, less than 5.02% of Java online submissions for Same

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else {
            if (p.val != q.val)  return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val &&
                isSameTree2(p.left, q.left) &&
                isSameTree2(p.right, q.right);

    }


    public static void main(String[] args) {
        SameTree solution = new SameTree();

        // Example trees: [1,2,3] and [1,2,3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean isSame = solution.isSameTree2(p, q);
        System.out.println("Are the given trees the same? " + isSame);
    }


}
