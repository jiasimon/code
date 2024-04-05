package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaryTreePreorder {
    // #589. N-ary Tree Preorder Traversal  https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/

    /*
    Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

    The number of nodes in the tree is in the range [0, 104].
    0 <= Node.val <= 10000
     */


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    // recursive
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (Node child : node.children) {
            preorderTraversal(child, result);
        }
    }

    public static void main(String[] args) {
        NaryTreePreorder solution = new NaryTreePreorder();

        // Test case: creating a sample tree
        Node child1 = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(child1, new Node(2), new Node(4)));

        List<Integer> result = solution.preorder(root);
        System.out.println("Test Case 1: " + result); // Output: [1, 3, 5, 6, 2, 4]
    }


}
