package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {
    // #337. House Robber III   https://leetcode.com/problems/house-robber-iii/
    /*
    Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

    Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
         3
        / \
       2   3
        \   \
         3   1

         3
        / \
       4   5
      / \   \
     1   3   1

     */



    // naive
    // TLE 122/124
    public int rob_naive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftKid = rob_naive(root.left) ;
        int rightKid = rob_naive(root.right);

        int sunzi =0;
        if (root.left != null) {
            sunzi += rob_naive(root.left.left) + rob_naive(root.left.right);
        }
        if (root.right != null) {
            sunzi += rob_naive(root.right.left) + rob_naive(root.right.right);
        }
        return Math.max(root.val + sunzi, leftKid + rightKid);
    }



    // memo
    // 2ms, 42.24%; 43.78mb, 79.51%
    public int rob_memo(TreeNode root) {
        if (root== null) return 0;
        Map<TreeNode, Integer> memo = new HashMap<>();
        return dfs_memo(root, memo);
    }

    private int dfs_memo(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int leftKid = dfs_memo(root.left, memo) ;
        int rightKid = dfs_memo(root.right, memo);

        int robCurrent =0;
        if (root.left != null) {
            robCurrent += dfs_memo(root.left.left, memo) + dfs_memo(root.left.right, memo);
        }
        if (root.right != null) {
            robCurrent += dfs_memo(root.right.left, memo) + dfs_memo(root.right.right, memo);
        }
        int tmp = Math.max(root.val + robCurrent, leftKid + rightKid);
        memo.put(root, tmp);
        return tmp;

    }




    public static void main(String[] args) {
        HouseRobber3 solution = new HouseRobber3();

        // Construct the tree (example: [3,2,3,null,3,null,1])
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(solution.rob_memo(root)); // Output: 7 (Rob nodes 3, 3, and 1)
    }

}
