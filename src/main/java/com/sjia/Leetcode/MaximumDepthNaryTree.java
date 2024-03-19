package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;


class Node {
    public int val; // Node's value
    public List<Node> children; // List of Node's children

    public Node() {}

    // Constructor with node's value
    public Node(int val) {
        this.val = val;
    }

    // Constructs node with value and list of children
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

public class MaximumDepthNaryTree {
    // #559. Maximum Depth of N-ary Tree    https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/

    /*
    Given a n-ary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

    Input: root = [1,null,3,2,4,null,5,6]       Output: 3

    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14] Output: 5

    The total number of nodes is in the range [0, 10^4].
    The depth of the n-ary tree is less than or equal to 1000.
     */



    public int maxDepth(Node root) {
        // An empty tree has a depth of 0.
        if (root == null) {
            return 0;
        }

        int maxDepth = 0; // Initialize max depth as 0

        // Loop through each child of root node
        if (root.children != null) {
            for (Node child : root.children) {
                // Calculate the depth for each child and compare it with current max depth
                maxDepth = Math.max(maxDepth, maxDepth(child));
            }
        }

        // Since we're already at root, we add 1 to account for the root's depth
        return maxDepth + 1;
    }

    public static void main(String[] args) {
        MaximumDepthNaryTree solution = new MaximumDepthNaryTree();

        // Test case: creating a sample tree
        Node child1 = new Node(3);
        Node child2 = new Node(2);
        Node child3 = new Node(4);
        List<Node> childrenOfRoot = new ArrayList<>();
        childrenOfRoot.add(child1);
        childrenOfRoot.add(child2);
        childrenOfRoot.add(child3);
        Node root = new Node(1, childrenOfRoot);

        System.out.println("Test Case 1: " + solution.maxDepth(root)); // Output: 2
    }

}
