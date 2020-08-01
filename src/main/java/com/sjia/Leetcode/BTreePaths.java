package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BTreePaths {
    // #257 https://leetcode.com/problems/binary-tree-paths/

    // Runtime: 10 ms, faster than 33.26% of Java online submissions for Binary Tree Paths.
    //Memory Usage: 40.9 MB, less than 5.41% of Java online submissions for Binary Tree Paths.
/*
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        pathHelper(root,"",result);
        return result;
    }

    private void pathHelper(TreeNode root, String path, List<String> result) {
        if (root != null) {
            path += root.val;
            if ( root.left == null && root.right == null) {
                result.add(path);
            } else {
                path += "->";
                pathHelper(root.left,path,result);
                pathHelper(root.right,path,result);
            }
        }
    }*/


    // put null check out of recursive
    // Runtime: 8 ms, faster than 62.42% of Java online submissions for Binary Tree Paths.
    //Memory Usage: 39.9 MB, less than 10.07% of Java online submissions for Binary Tree Paths.
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root!=null) pathMaker(root,"",result);
        return result;
    }

    private void pathMaker(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null)  result.add(path+root.val);
        if (root.left != null) pathMaker(root.left, path+root.val + "->", result);
        if (root.right != null) pathMaker(root.right, path+root.val + "->", result);
    }


}
