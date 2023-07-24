package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    // #257. Binary Tree Paths https://leetcode.com/problems/binary-tree-paths/

    /*
    Given the root of a binary tree, return all root-to-leaf paths in any order.
    A leaf is a node with no children.

    Input: root = [1,2,3,null,5]    Output: ["1->2->5","1->3"]
    Input: root = [1]   Output: ["1"]
    The number of nodes in the tree is in the range [1, 100].
     */



    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        return result;
    }




    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths solution = new BinaryTreePaths();
        List<String> paths = solution.binaryTreePaths(root);

        // Print the root-to-leaf paths
        System.out.println("Binary Tree Paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }

}
