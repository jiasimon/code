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



    // null check out of recursive, compare to preorder,
    // 8ms, 61.84% ; 41.84mb, 43.74%
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if ( root != null) {
            pathHelper(root, "", result);
        }

        return result;
    }

    private void pathHelper(TreeNode root, String path, List<String> result) {
        if( root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if ( root.left != null) {
            pathHelper(root.left, path + root.val + "->", result);
        }
        if ( root.right != null) {
            pathHelper(root.right, path + root.val + "->", result);
        }
    }



    // preorder, root.left == null && root.right == null
    public List<String> binaryTreePathsPreorder(TreeNode root) {
        List<String> res = new ArrayList<>();
        helperPreorder(root, "", res);
        return res;
    }

    private void helperPreorder(TreeNode root, String path, List<String> res) {
        if (root == null ) return;

        String tmpPath = path + root.val + "->";
        if( root.left == null && root.right == null) {
            tmpPath = path + root.val;
            res.add(tmpPath);
        }

        helperPreorder(root.left,tmpPath, res);
        helperPreorder(root.right, tmpPath, res);
    }


    // Memory Limit Exceeded, root should not have recur
    //
    private void dfsPreorder(TreeNode root, String path, List<String> res) {
        if (root == null) return ;

        // root
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        // left subtree
        dfsPreorder(root.left ,path + root.val + "->",res);
        // right subtree
        dfsPreorder(root.right ,path + root.val + "->",res);
    }



    // StringBuilder, backtrack required
    /*
    no backtracking, 1->2->2->5 ; 1->2->2->51->3

     */
    public List<String> binaryTreePathsSB(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder sb, List<String> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans.add(sb.append(root.val).toString());
            return;
        }
        final int length = sb.length();
        dfs(root.left, sb.append(root.val).append("->"), ans);
        sb.setLength(length);
        dfs(root.right, sb.append(root.val).append("->"), ans);
        sb.setLength(length);
    }



    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths solution = new BinaryTreePaths();
        List<String> paths = solution.binaryTreePathsSB(root);

        // Print the root-to-leaf paths
        // 1->2->5 , 1->3
        System.out.println("Binary Tree Paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }

}
