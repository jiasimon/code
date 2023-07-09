package com.sjia.Leetcode;

public class SumRootLeafNumbers {
    // #129. Sum Root to Leaf Numbers   https://leetcode.com/problems/sum-root-to-leaf-numbers/
    /*
    Each root-to-leaf path in the tree represents a number. A leaf node is a node with no children.
    the answer will fit in a 32-bit integer.

    Input: root = [1,2,3]   Output: 25
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    sum = 12 + 13 = 25.

    Input: root = [4,9,0,5,1]   Output: 1026
    495 + 491 + 40 = 1026

    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 9
    The depth of the tree will not exceed 10.

     */

    public int sumNumbers(TreeNode root) {
        return dfsSumHelper(root, 0);
    }

    private int dfsSumHelper(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) return currentSum * 10 + root.val;
        int left = dfsSumHelper(root.left, currentSum * 10 + root.val);
        int right = dfsSumHelper(root.right, currentSum * 10 + root.val);
        return left + right;

    }



    public static void main(String[] args) {
        SumRootLeafNumbers solution = new SumRootLeafNumbers();

        // Test case
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        int result = solution.sumNumbers(root);

        // Print the result
        System.out.println("Sum of Root to Leaf Numbers: " + result);  // Output: 1026
    }


}
