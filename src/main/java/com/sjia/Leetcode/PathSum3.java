package com.sjia.Leetcode;

public class PathSum3 {

    // #437. Path Sum III https://leetcode.com/problems/path-sum-iii/

    /*
    Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

    The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

    -10^9 <= Node.val <= 10^9
    -1000 <= targetSum <= 1000

    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1

    Return 3. The paths that sum to 8 are:

    1.  5 -> 3
    2.  5 -> 2 -> 1
    3. -3 -> 11

     */



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



    public static void main(String[] args) {
        PathSum3 solution = new PathSum3();

        // Example usage:
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int count = solution.pathSum(root, targetSum);
        System.out.println("Number of Paths with Sum " + targetSum + ": " + count); // Output: 3
    }

}
