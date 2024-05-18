package com.sjia.Leetcode600;



import com.sjia.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    // #652. Find Duplicate Subtrees    https://leetcode.com/problems/find-duplicate-subtrees/description/
    /*
    Given the root of a binary tree, return all duplicate subtrees.
    For each kind of duplicate subtrees, you only need to return the root node of any one of them.
    Two trees are duplicate if they have the same structure with the same node values.
     */

    //treeNode
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // serialize, key = node.val + ',' + serialize(node.left) + ',' + serialize(node.right)

    Map<String, Integer> count;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        result = new ArrayList<>();
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null) return "#";

        String key = node.val + "," + serialize(node.left) + "," + serialize(node.right);
        count.put(key, count.getOrDefault(key, 0) + 1);
        if (count.get(key) == 2) {
            result.add(node);
        }

        return key;
    }


    public static void main(String[] args) {
        // Test case
        // Constructing tree:
        //         1
        //        / \
        //       2   3
        //      /   / \
        //     4   2*  4*
        //        / \
        //       4*  4*
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(4);

        FindDuplicateSubtrees solution = new FindDuplicateSubtrees();
        List<TreeNode> duplicates = solution.findDuplicateSubtrees(root);

        System.out.println("Duplicate subtrees:");
        for (TreeNode duplicate : duplicates) {
            System.out.println(duplicate.val);
        }
    }

}
