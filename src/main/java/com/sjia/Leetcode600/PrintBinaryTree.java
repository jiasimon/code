package com.sjia.Leetcode600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintBinaryTree {
    // #655. Print Binary Tree  https://leetcode.com/problems/print-binary-tree/description/
    /*
    Input: root = [1,2]
    Output:
    [["","1",""],
     ["2","",""]]

     The number of nodes in the tree is in the range [1, 2^10].
     -99 <= Node.val <= 99
     The depth of the tree will be in the range [1, 10].
     */

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (int) Math.pow(2, height) - 1;

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(width, ""));
            result.add(row);
        }

        fill(result, root, 0, 0, width - 1);
        return result;
    }

    private void fill(List<List<String>> result, TreeNode node, int level, int left, int right) {
        if (node == null) {
            return;
        }

        int mid = (left + right) / 2;
        result.get(level).set(mid, Integer.toString(node.val));

        fill(result, node.left, level + 1, left, mid - 1);
        fill(result, node.right, level + 1, mid + 1, right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public static void main(String[] args) {
        // Test case
        // Constructing tree:
        //         1
        //        / \
        //       2   3
        //        \   \
        //         4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        PrintBinaryTree solution = new PrintBinaryTree();
        List<List<String>> result = solution.printTree(root);

        // Print the result in a readable format
        for (List<String> row : result) {
            System.out.println(row);
        }
    }



}
