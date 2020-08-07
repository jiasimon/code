package com.sjia.Leetcode;

public class PathSum3 {

    // #437 https://leetcode.com/problems/path-sum-iii/
    // The path does not need to start or end at the root or a leaf,
    // but it must go downwards (traveling only from parent nodes to child nodes).


    // Runtime: 22 ms, faster than 32.36% of Java online submissions for Path Sum III.
    //Memory Usage: 39.6 MB, less than 6.67% of Java online submissions for Path Sum III.
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumHelper(root, sum) + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int pathSumHelper(TreeNode root, int sum) {
        if(root == null) return 0;
        int result = pathSumHelper(root.left, sum - root.val) +
                pathSumHelper(root.right, sum - root.val);
        return sum == root.val ? result+1 : result;
    }


}
