package com.sjia.Leetcode;

import java.util.*;

public class MostFrequentSubtreeSum {
    // #508. Most Frequent Subtree Sum  https://leetcode.com/problems/most-frequent-subtree-sum/

    /*
    Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

    The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

    Input: root = [5,2,-3]      Output: [2,-3,4]
    Input: root = [5,2,-5]      Output: [2]

    The number of nodes in the tree is in the range [1, 104].
    -10^5 <= Node.val <= 10^5
     */

    Map<Integer, Integer> sumFrequency;
    int maxFrequency;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        sumFrequency = new HashMap<>();
        maxFrequency = 0;

        calculateSubtreeSum(root);

        List<Integer> mostFrequentSums = new ArrayList<>();
        for (int key : sumFrequency.keySet()) {
            if (sumFrequency.get(key) == maxFrequency) {
                mostFrequentSums.add(key);
            }
        }

        int[] result = new int[mostFrequentSums.size()];
        for (int i = 0; i < mostFrequentSums.size(); i++) {
            result[i] = mostFrequentSums.get(i);
        }

        return result;
    }

    private int calculateSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = calculateSubtreeSum(node.left);
        int rightSum = calculateSubtreeSum(node.right);

        int subtreeSum = leftSum + rightSum + node.val;
        int frequency = sumFrequency.getOrDefault(subtreeSum, 0) + 1;
        sumFrequency.put(subtreeSum, frequency);

        maxFrequency = Math.max(maxFrequency, frequency);

        return subtreeSum;
    }

    public static void main(String[] args) {
        MostFrequentSubtreeSum solution = new MostFrequentSubtreeSum();

        // Example tree creation for testing
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        int[] frequentSums = solution.findFrequentTreeSum(root);
        System.out.println("Most Frequent Subtree Sums: " + Arrays.toString(frequentSums));
    }

}
