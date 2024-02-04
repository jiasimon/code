package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceBST {
    // #530. Minimum Absolute Difference in BST     https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

    /*
    Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

   1
    \
     3
    /
   2

        4
      2     6
    1   3

   Input: root = [4,2,6,1,3]    Output: 1

    The number of nodes in the tree is in the range [2, 10000].

     */

    // inOrderTraversal
    public int getMinimumDifference(TreeNode root) {
        List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < sortedValues.size(); i++) {
            minDiff = Math.min(minDiff, sortedValues.get(i) - sortedValues.get(i - 1));
        }
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> sortedValues) {
        if (node == null) return;

        inOrderTraversal(node.left, sortedValues);
        sortedValues.add(node.val);
        inOrderTraversal(node.right, sortedValues);
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceBST solution = new MinimumAbsoluteDifferenceBST();

        // Construct the example BST: [1, null, 3, 2]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        int minDiff = solution.getMinimumDifference(root);
        System.out.println("Minimum absolute difference in the BST: " + minDiff);
    }


}
