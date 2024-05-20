package com.sjia.Leetcode600;


import java.util.HashSet;
import java.util.Set;


public class TwoSum4 {
    // #653. Two Sum IV - Input is a BST    https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
    /*
    Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

    Input: root = [5,3,6,2,4,null,7], k = 9     Output: true
    Input: root = [5,3,6,2,4,null,7], k = 28    Output: false

    The number of nodes in the tree is in the range [1, 10^4]
    -10^4 <= Node.val <= 10^4
    -10^5 <= k <= 10^5

     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }

        if (set.contains(k - node.val)) {
            return true;
        }

        set.add(node.val);

        return find(node.left, k, set) || find(node.right, k, set);
    }

    public static void main(String[] args) {
        // Test case
        // Constructing tree:
        //         5
        //        / \
        //       3   6
        //      / \   \
        //     2   4   7
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;

        TwoSum4 solution = new TwoSum4();
        boolean result = solution.findTarget(root, k);

        System.out.println("Result: " + result);  // Output should be true as 2 + 7 = 9
    }

}
