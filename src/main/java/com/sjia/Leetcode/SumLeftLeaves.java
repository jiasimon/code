package com.sjia.Leetcode;

public class SumLeftLeaves {

    // #404. Sum of Left Leaves https://leetcode.com/problems/sum-of-left-leaves/
    // Find the sum of all left leaves in a given binary tree.

    /*
    Given the root of a binary tree, return the sum of all left leaves.

    A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

    Input: root = [3,9,20,null,null,15,7]   Output: 24

        3
       / \
      9  20
        /  \
       15   7

     */


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
    //Memory Usage: 37.1 MB, less than 87.17% of Java online submissions for Sum of Left Leaves.

    int sum=0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if ( root.left !=null &&   root.left.left == null && root.left.right == null)
            sum += root.left.val;
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }



    // 0 ms, 100%; 40.2 MB, 73.71%
    public int sumOfLeftLeaves_recursive(TreeNode root) {
        if ( root == null)  {
            return 0;
        }

        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        // Recurse on both left and right subtrees
        res += sumOfLeftLeaves(root.left);
        res += sumOfLeftLeaves(root.right);

        return res;

    }


    // recursive with flag
    // 0 ms, 100%; 40.2 MB, 61.31%
    public int sumOfLeftLeaves_recursive_flag(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        return helper(root.left, true) + helper(root.right, false);
    }


    public static void main(String[] args) {
        SumLeftLeaves solution = new SumLeftLeaves();

        // Constructing a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int sum = solution.sumOfLeftLeaves_recursive(root);
        System.out.println("Sum of left leaves: " + sum);  // 24
    }

}
