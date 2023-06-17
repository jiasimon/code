package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    // #95. Unique Binary Search Trees II  https://leetcode.com/problems/unique-binary-search-trees-ii/description/

    /*
    Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
    1 <= n <= 8
     */

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubtrees = generateTrees(i + 1, end);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees2 solution = new UniqueBinarySearchTrees2();
        List<TreeNode> result = solution.generateTrees(3);
        for (TreeNode root : result) {
            printTree(root);
            System.out.println();
        }
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

}
